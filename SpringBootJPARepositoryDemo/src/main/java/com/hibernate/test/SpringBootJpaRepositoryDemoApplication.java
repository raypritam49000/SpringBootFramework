package com.hibernate.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hibernate.test.dao.UserRepository;
import com.hibernate.test.model.User;

@SpringBootApplication
public class SpringBootJpaRepositoryDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootJpaRepositoryDemoApplication.class, args);
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		System.out.println(userRepository);
		
	    userRepository.save(new User("Pritam Ray","Java Developer"));
	    userRepository.save(new User("Ram Kumar","JavaScript Developer"));
	    userRepository.save(new User("Omi Verma","PHP Developer"));
	    userRepository.save(new User("Deepak Sharma","Full Stack Developer"));
	    userRepository.save(new User("Cahandan Kumar","Android"));
	    
	}

}
