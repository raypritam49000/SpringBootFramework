package com.jpa.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class SpringBootJpaProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootJpaProjectApplication.class, args);
		UserRepository userRepository = ctx.getBean(UserRepository.class);

		User user1 = new User("Pritam Ray", "Ropar", "8699535682");
		User user2 = new User("Omi Verma", "Prem Nagar", "7650034512");
		User user3 = new User("Raj Kumar", "Rail", "8656782367");
		User user4 = new User("Chandan Kumar", "Asron", "9041415682");
		User user5 = new User("Suraj Kumar", "UK", "7009382367");
		User user6 = new User("Amit Kumar", "Asron", "7891415682");
		User user9 = new User("Suraj Kumar", "Asron", "7891415682");
		User user10 = new User("Amit Kumar", "Asron", "7891415682");

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		userRepository.save(user5);
		userRepository.save(user6);
		userRepository.save(user9);
		userRepository.save(user10);

		List<User> users = (List<User>) userRepository.findAll();
		System.out.println(users);
		for (User user : users) {
			System.out.println(user.getId() + " " + user.getName() + " " + user.getPhone() + " " + user.getCity());
		}

		System.out.println("------Save All------");
		Iterable<User> list = Arrays.asList(user1, user2, user3, user4);
		userRepository.saveAll(list);

		System.out.println("-------Update User-----");
		Optional<User> optional = userRepository.findById(3);
		User user = optional.get();

		if (user != null) {
			user.setCity("Chandigarh");
			user.setPhone("5634230956");
			userRepository.save(user);
		}

		System.out.println("---------Delete User---------");
		userRepository.deleteById(4);

		List<User> users1 = userRepository.findByName("Pritam Ray");
		users1.forEach(e -> System.out.println(e.getName()));

		User user8 = userRepository.findByNameAndCity("Omi Verma", "Prem Nagar");
		if (user8 != null) {
			System.out.println(user8);
		}

		userRepository.findByNameOrCity("Pritam Ray", "Asron").forEach(e -> System.out.println(e));

		userRepository.findByIdBetween(2, 5).forEach(e -> System.out.println(e));

		userRepository.findByIdLessThan(6).forEach(e -> System.out.println(e));

		userRepository.findByIdGreaterThan(5).forEach(e -> System.out.println(e));

		userRepository.getAllUsers().forEach(e -> System.out.println(e));

		userRepository.getUserByName("Amit Kumar").forEach(e -> System.out.println(e));

		userRepository.getUserByNameAndCity("Suraj Kumar", "Asron").forEach(e -> System.out.println(e));
	    
	    userRepository.getAllUsers().forEach(e->System.out.println(e));
	}

}
