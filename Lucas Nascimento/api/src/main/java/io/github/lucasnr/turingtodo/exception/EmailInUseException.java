package io.github.lucasnr.turingtodo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmailInUseException extends RuntimeException {

    public EmailInUseException(String email) {
        super(String.format("Já existe um usuário com o email [%s]", email));
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
