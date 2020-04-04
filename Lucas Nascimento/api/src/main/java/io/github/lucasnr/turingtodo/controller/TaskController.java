package io.github.lucasnr.turingtodo.controller;

import io.github.lucasnr.turingtodo.dto.TaskDTO;
import io.github.lucasnr.turingtodo.dto.TaskUpdateDTO;
import io.github.lucasnr.turingtodo.exception.TaskAlreadyDoneException;
import io.github.lucasnr.turingtodo.exception.TaskNotFoundByIdException;
import io.github.lucasnr.turingtodo.exception.UserNotFoundByIdException;
import io.github.lucasnr.turingtodo.model.Task;
import io.github.lucasnr.turingtodo.model.User;
import io.github.lucasnr.turingtodo.service.TaskService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users/{userId}/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {

    @Autowired
    private TaskService service;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page<TaskDTO>> findAll(@PathVariable("userId") Integer userId, Pageable pageable) {
        findUserByIdOrThrowException(userId);

        Page<Task> page = service.findByUserId(userId, pageable);
        return page.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(page.map(TaskDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable("userId") Integer userId, @PathVariable("id") Integer id) {
        Task task = findByIdOrThrowException(id, userId);
        return ResponseEntity.ok(new TaskDTO(task));
    }

    @Transactional
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> create(@PathVariable("userId") Integer userId,
                                          @RequestBody @Valid TaskDTO taskDTO,
                                          UriComponentsBuilder uriBuilder) {
        User user = findUserByIdOrThrowException(userId);
        Task task = taskDTO.build();
        task.setUser(user);

        service.save(task);
        URI location = uriBuilder.path("/user/{id}/task/{taskId}")
                .buildAndExpand(user.getId(), task.getId()).toUri();

        TaskDTO createdTask = new TaskDTO(task);
        return ResponseEntity.created(location).body(createdTask);
    }

    @Transactional
    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> update(@RequestBody @Valid TaskUpdateDTO taskDTO,
                                          @PathVariable("id") Integer id, @PathVariable("userId") Integer userId) {
        Task task = findByIdOrThrowException(id, userId);
        if(task.isDone())
            throw new TaskAlreadyDoneException();

        if(! StringUtils.isEmpty(taskDTO.getText()))
            task.setText(taskDTO.getText());

        if(taskDTO.getDatetime() != null)
            task.setDateTime(taskDTO.getDatetime());

        if(taskDTO.isDone())
            task.setDone(true);

        return ResponseEntity.ok(new TaskDTO(task));
    }

    private Task findByIdOrThrowException(Integer id, Integer userId) {
        User user = findUserByIdOrThrowException(userId);
        Optional<Task> optional = service.findByIdAndUserId(id, user.getId());
        Task task = optional.orElseThrow(() -> new TaskNotFoundByIdException(id));
        return task;
    }

    private User findUserByIdOrThrowException(Integer userId) {
        if (userService.existsById(userId))
            return new User(userId);

        throw new UserNotFoundByIdException(userId);
    }

}
