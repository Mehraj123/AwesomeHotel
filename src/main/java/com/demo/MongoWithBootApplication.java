package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// @EnableScheduling
@EnableEurekaClient
public class MongoWithBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoWithBootApplication.class, args);
	}
}
