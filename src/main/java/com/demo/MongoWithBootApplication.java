package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Starter class of the project
 * 
 * @author Mehraj Malik
 * @version 1.0
 *
 */
@SpringBootApplication
public class MongoWithBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoWithBootApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
