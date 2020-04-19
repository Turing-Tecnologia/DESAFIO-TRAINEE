package io.github.lucasnr.turingtodo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.lucasnr.turingtodo.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class UserDTO {

    private Integer id;
    private String name;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    @JsonProperty(value = "avatar_url")
    private String avatarUrl;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.avatarUrl = user.getAvatarUrl();
    }

    public User build() {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAvatarUrl(avatarUrl);
        return user;
    }
}
