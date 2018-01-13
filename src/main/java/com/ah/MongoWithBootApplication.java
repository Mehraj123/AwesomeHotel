package com.ah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableScheduling
// @PropertySource("file:config.properties")
// @PropertySource("#{systemEnvironment['LOCATION']}")
// @EnableEurekaClient
public class MongoWithBootApplication {

	/*@Value("#{systemEnvironment['LOCATION']}")
	private String location;
	
	public void hi() {
		System.out.println("--- ENV " + location);
	}*/

	public static void main(String[] args) {
		// SpringApplication.run(MongoWithBootApplication.class,
		// args).getBean(MongoWithBootApplication.class).hi();;

		SpringApplication.run(MongoWithBootApplication.class, args);
	}
}
