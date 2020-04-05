package io.github.lucasnr.turingtodo.repository;

import io.github.lucasnr.turingtodo.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    public Page<Task> findByUserId(Integer userId, Pageable pageable);

    public Optional<Task> findByIdAndUserId(Integer id, Integer userId);

    public Page<Task> findByUserIdAndDoneFalse(Integer userId, Pageable pageable);

    public Page<Task> findByUserIdAndDoneTrue(Integer userId, Pageable pageable);
}
