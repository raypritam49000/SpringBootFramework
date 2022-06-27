package com.springboot.mvc.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mvc.test.models.User;
import com.springboot.mvc.test.repository.UserRespository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRespository userRespository;

	@Override
	public void saveUser(User user) {
		User user1 = this.userRespository.findUserByMobile(user.getMobile());
		if(user.getMobile().equals(user1.getMobile())) 
		{
			System.out.println("User are already used mobile number!!!");
		}
		this.userRespository.save(user);
	}

	@Override
	public List<User> findAllUser() {
		Iterable<User> iterable = this.userRespository.findAll();
		List<User> list = (List<User>) iterable;
		return list;
	}

	@Override
	public void deleteUserById(int id) {
		this.userRespository.deleteById(id);
	}

	@Override
	public User findUserById(int id) {
		User user = this.userRespository.findUserById(id);
		return user;
	}

}
