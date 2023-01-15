package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.security.models.User;

@Service
public class UserService {

	@Autowired
	private UserDetailsManager manager;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void addUser(User user) {
		user.setPassword(this.encoder.encode(user.getPassword()));
		this.manager.createUser(user);;
	}
	
}
