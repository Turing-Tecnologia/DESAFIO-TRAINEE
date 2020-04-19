package io.github.lucasnr.turingtodo.controller;

import io.github.lucasnr.turingtodo.dto.TaskDTO;
import io.github.lucasnr.turingtodo.dto.UserDTO;
import io.github.lucasnr.turingtodo.dto.UserUpdateDTO;
import io.github.lucasnr.turingtodo.exception.BadRequestException;
import io.github.lucasnr.turingtodo.exception.EmailInUseException;
import io.github.lucasnr.turingtodo.exception.InvalidTokenException;
import io.github.lucasnr.turingtodo.exception.UserNotFoundByIdException;
import io.github.lucasnr.turingtodo.model.Task;
import io.github.lucasnr.turingtodo.model.User;
import io.github.lucasnr.turingtodo.service.TaskService;
import io.github.lucasnr.turingtodo.service.TokenService;
import io.github.lucasnr.turingtodo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public Page<UserDTO> findAll(Pageable pageable) {
        return service.findAll(pageable).map(UserDTO::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Integer id) {
        Optional<User> optional = service.findById(id);
        User user = optional.orElseThrow(() -> new UserNotFoundByIdException(id));
        return ResponseEntity.ok(new UserDTO(user));
    }

    @GetMapping("/me")
    public  ResponseEntity<UserDTO> findByToken(@RequestHeader("X-AUTH-TOKEN") String token) {
        if(! tokenService.isValidToken(token))
            throw new InvalidTokenException();

        Integer id = tokenService.getUserId(token);
        User user = service.findById(id).get();
        return ResponseEntity.ok(new UserDTO(user));
    }

    @GetMapping("/me/tasks")
    public  ResponseEntity<Page<TaskDTO>> findByToken(@RequestHeader("X-AUTH-TOKEN") String token,
                                                      @RequestParam(value = "done", required = false) boolean done,
                                                      Pageable pageable) {
        if(! tokenService.isValidToken(token))
            throw new InvalidTokenException();

        Integer id = tokenService.getUserId(token);
        Page<Task> page;
        if(done)
            page = taskService.findByUserIdAndIsDone(id, pageable);
        else
            page = taskService.findByUserId(id, pageable);
        return page.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(page.map(TaskDTO::new));
    }

    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable("id") Integer id, @RequestBody @Valid UserUpdateDTO userDTO) {
        Optional<User> optional = service.findById(id);
        User user = optional.orElseThrow(() -> new UserNotFoundByIdException(id));

        if(!StringUtils.isEmpty(userDTO.getName()))
            user.setName(userDTO.getName());

        if(!StringUtils.isEmpty(userDTO.getEmail())) {
            boolean exists = service.existsByEmail(userDTO.getEmail());
            if(exists)
                throw new BadRequestException("Este endereço de e-mail já está em uso");
            else
                user.setEmail(userDTO.getEmail());
        }

        if(!StringUtils.isEmpty(userDTO.getPassword()))
            user.setPassword(userDTO.getPassword());

        if(!StringUtils.isEmpty(userDTO.getAvatarUrl()))
            user.setAvatarUrl(userDTO.getAvatarUrl());

        return ResponseEntity.ok(new UserDTO(user));
    }

    @Transactional
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> create(@RequestBody @Valid  UserDTO userDTO, UriComponentsBuilder uriBuilder) {
        User user = userDTO.build();
        if(service.existsByEmail(user.getEmail()))
            throw new EmailInUseException(user.getEmail());

        service.save(user);
        URI location = uriBuilder.path("/user/{id}")
                .buildAndExpand(user.getId()).toUri();

        UserDTO createdUser = new UserDTO(user);
        return ResponseEntity.created(location).body(createdUser);
    }
}
