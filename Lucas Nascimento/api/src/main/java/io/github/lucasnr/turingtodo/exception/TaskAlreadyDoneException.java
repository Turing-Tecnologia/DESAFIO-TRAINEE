package io.github.lucasnr.turingtodo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "A tarefa já foi concluida")
public class TaskAlreadyDoneException extends RuntimeException {
}
