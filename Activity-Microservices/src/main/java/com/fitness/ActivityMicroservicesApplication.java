package com.fitness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class ActivityMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityMicroservicesApplication.class, args);
	}

}
