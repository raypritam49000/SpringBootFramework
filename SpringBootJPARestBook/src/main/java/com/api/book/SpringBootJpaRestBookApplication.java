package com.api.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.api.book.dao")
public class SpringBootJpaRestBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaRestBookApplication.class, args);
	}

}
