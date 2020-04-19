package io.github.lucasnr.turingtodo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST, reason = "O token informado não é válido")
public class InvalidTokenException extends RuntimeException {
}
