package com.springboot.mvc.test.services;

import java.util.List;

import com.springboot.mvc.test.models.User;

public interface UserService {
	public abstract void saveUser(User user);

	public abstract List<User> findAllUser();

	public abstract void deleteUserById(int id);

	public abstract User findUserById(int id);
}
