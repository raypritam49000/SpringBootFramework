package com.springboot.fileuploading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFileUploadigDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFileUploadigDemoApplication.class, args);
		
		System.out.println(System.getProperty("user.dir"));
	}

}
