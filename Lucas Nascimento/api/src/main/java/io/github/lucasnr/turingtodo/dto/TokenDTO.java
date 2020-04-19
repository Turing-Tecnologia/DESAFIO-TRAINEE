package io.github.lucasnr.turingtodo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class TokenDTO {

    @NotNull
    @NotEmpty
    private String token;

    private boolean valid;

    public TokenDTO(String token) {
        this.token = token;
        this.valid = true;
    }

    public TokenDTO() {
        this.valid = true;
    }
}

