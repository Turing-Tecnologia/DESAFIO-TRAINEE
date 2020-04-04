package io.github.lucasnr.turingtodo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundByIdException extends RuntimeException {

    public UserNotFoundByIdException(Integer id) {
        super(String.format("Não existe usuário com o ID [%d]", id));
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
