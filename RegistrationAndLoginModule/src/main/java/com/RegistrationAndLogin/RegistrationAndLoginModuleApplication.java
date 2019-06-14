package com.RegistrationAndLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.fashionhub.login", "com.fashionhub.register",
		"com.fashionhub.security.service.configuration" })
@EntityScan(basePackages = { "com.fashionhub.login.entity", "com.fashionhub.register.entity","com.fashionhub.register.util.entity" })
@EnableJpaRepositories(basePackages = { "com.fashionhub.login.repository", "com.fashionhub.register.repository","com.fashionhub.register.util.entity.repository" })
public class RegistrationAndLoginModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationAndLoginModuleApplication.class, args);
	}

}
