package com.hibernate.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hibernate.test.dao.UserDao;
import com.hibernate.test.model.User;

@SpringBootApplication
public class SpringBootJpaHibernateDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootJpaHibernateDemoApplication.class, args);
		UserDao userDao = ctx.getBean(UserDao.class);
		System.out.println(userDao);
		User user = new User("Pritam Ray","Java Developer");
		userDao.addUser(user);
	}

}
