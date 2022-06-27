package com.rest.api.springbootrestapidemo.service;

import java.util.List;
import java.util.Optional;

import com.rest.api.springbootrestapidemo.model.User;
import com.rest.api.springbootrestapidemo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		Iterable<User> iterable = this.userRepository.findAll();
		List<User> list = (List<User>) iterable;
		return list;
	}

	@Override
	public User getUserById(int id) {
		Optional<User> optional = this.userRepository.findById(id);
		User user = optional.get();
		return user;
	}

	@Override
	public void updateUserById(User user, int id) {
		user.setId(id);
		this.userRepository.save(user);
	}

	@Override
	public void deleteUserById(int id) {
		this.userRepository.deleteById(id);
	}

	@Override
	public void saveAllUser(List<User> list) {
		Iterable<User> iterable = list;
		this.userRepository.saveAll(iterable);
	}

	@Override
	public void deleteAllUser(List<User> list) {
		Iterable<User> iterable = list;
		this.userRepository.deleteAll(iterable);
	}

	@Override
	public User getUserByName(String name) {
		return this.userRepository.findUserByName(name);
	}

	@Override
	public User getUserByNameandCity(String name, String city) {
		return this.userRepository.findUserByNameAndCity(name, city);
	}

}
