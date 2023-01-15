package com.rest.api.springbootrestapidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "User API",version = "2.0",description = "User Microservices") )
public class SpringbootrestapidemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestapidemoApplication.class, args);
	}

}
