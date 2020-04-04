package io.github.lucasnr.turingtodo;

import io.github.lucasnr.turingtodo.config.WebCorsConfig;
import io.github.lucasnr.turingtodo.controller.UserController;
import io.github.lucasnr.turingtodo.model.User;
import io.github.lucasnr.turingtodo.repository.UserRepository;
import io.github.lucasnr.turingtodo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@ComponentScan(basePackageClasses = {UserController.class, UserService.class, WebCorsConfig.class })
@EntityScan(basePackageClasses = {User.class})
@EnableJpaRepositories(basePackageClasses = {UserRepository.class})
public class TuringTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuringTodoApplication.class, args);
	}

}
