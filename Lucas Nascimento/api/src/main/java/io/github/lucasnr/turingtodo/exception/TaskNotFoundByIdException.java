package io.github.lucasnr.turingtodo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TaskNotFoundByIdException extends RuntimeException {

    public TaskNotFoundByIdException(Integer id) {
        super(String.format("Não existe tarefa com o ID [%d]", id));
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
