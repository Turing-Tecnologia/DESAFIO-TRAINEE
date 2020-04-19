package io.github.lucasnr.turingtodo.service;

import io.github.lucasnr.turingtodo.model.Task;
import io.github.lucasnr.turingtodo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public void save(Task task) {
        task = repository.save(task);
    }

    public Page<Task> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Task> findByUserId(Integer userId, Pageable pageable) {
        return repository.findByUserIdAndDoneFalse(userId, pageable);
    }

    public Page<Task> findByUserIdAndIsDone(Integer userId, Pageable pageable) {
        return  repository.findByUserIdAndDoneTrue(userId, pageable);
    }

    public Optional<Task> findByIdAndUserId(Integer id, Integer userId) {
        return repository.findByIdAndUserId(id, userId);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
