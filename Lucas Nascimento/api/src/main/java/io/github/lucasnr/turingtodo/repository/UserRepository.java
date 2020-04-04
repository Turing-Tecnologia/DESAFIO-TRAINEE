package io.github.lucasnr.turingtodo.repository;

import io.github.lucasnr.turingtodo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public boolean existsByEmail(String email);
}
