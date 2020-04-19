package io.github.lucasnr.turingtodo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    @Column(columnDefinition = "CHAR")
    private String password;

    @Column(name = "AVATAR_URL")
    private String avatarUrl;

    public User(Integer id) {
        this.id = id;
    }
}
