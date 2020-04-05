package io.github.lucasnr.turingtodo.controller;

import io.github.lucasnr.turingtodo.dto.TokenDTO;
import io.github.lucasnr.turingtodo.dto.UserDTO;
import io.github.lucasnr.turingtodo.exception.NotFoundException;
import io.github.lucasnr.turingtodo.model.User;
import io.github.lucasnr.turingtodo.service.TokenService;
import io.github.lucasnr.turingtodo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

    @Autowired
    private TokenService service;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<TokenDTO> getTokenByCredentials(@RequestBody @Valid UserDTO userDTO) {
        Optional<User> user = userService.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
        return ResponseEntity.ok(user.map(service::generate).orElseThrow(
                () -> new NotFoundException("Não existe usuário com este e-mail e senha")));
    }

    @PostMapping(value = "/validate")
    public ResponseEntity<TokenDTO> validate(@RequestBody @Valid TokenDTO token) {
        boolean valid = service.isValidToken(token.getToken());
        return ResponseEntity.ok(new TokenDTO(token.getToken(), valid));
    }

}
