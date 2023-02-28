package ru.velikanov.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotEmpty;
@SpringBootApplication
public class VelikanovTodolistApplication {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

	public static void main(String[] args) {
		SpringApplication.run(VelikanovTodolistApplication.class, args);
	}

}
