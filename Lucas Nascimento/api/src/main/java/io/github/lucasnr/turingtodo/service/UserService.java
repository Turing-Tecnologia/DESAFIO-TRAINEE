package io.github.lucasnr.turingtodo.service;

import io.github.lucasnr.turingtodo.model.User;
import io.github.lucasnr.turingtodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void save(User user) {
        user = repository.save(user);
    }

    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    public Optional<User> findById(Integer id) {
        return repository.findById(id);
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
