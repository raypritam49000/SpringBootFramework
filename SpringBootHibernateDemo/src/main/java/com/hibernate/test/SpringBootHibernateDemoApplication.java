package com.hibernate.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication

@Configuration
@ComponentScan
@EnableAutoConfiguration 
public class SpringBootHibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateDemoApplication.class, args);
	}

}
