package io.github.lucasnr.turingtodo.controller;

import io.github.lucasnr.turingtodo.dto.UserDTO;
import io.github.lucasnr.turingtodo.exception.EmailInUseException;
import io.github.lucasnr.turingtodo.exception.UserNotFoundByIdException;
import io.github.lucasnr.turingtodo.model.User;
import io.github.lucasnr.turingtodo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
