package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableScheduling
// @PropertySource("file:config.properties")
// @PropertySource("#{systemEnvironment['LOCATION']}")
public class MongoWithBootApplication {

	@Value("#{systemEnvironment['LOCATION']}")
	private String location;

	public void hi() {
		System.out.println("--- ENV "+location);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MongoWithBootApplication.class, args).getBean(MongoWithBootApplication.class).hi();;
		

	}
}
