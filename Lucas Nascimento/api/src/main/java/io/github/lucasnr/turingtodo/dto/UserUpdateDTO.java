package io.github.lucasnr.turingtodo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserUpdateDTO {

    private String name;
    private String email;
    private String password;
    @JsonProperty("avatar_url")
    private String avatarUrl;
}
