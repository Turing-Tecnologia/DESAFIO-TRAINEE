package io.github.lucasnr.turingtodo.repository;

import io.github.lucasnr.turingtodo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public boolean existsByEmail(String email);

    public Optional<User> findByEmailAndPassword(String email, String password);
}
