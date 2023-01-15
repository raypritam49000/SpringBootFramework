package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.security.models.User;
import com.security.repository.UserRepository;

public class LoginUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findUserByUsername(username);
		System.out.println(user);
		  if (user == null) {
	            throw new UsernameNotFoundException("Could not find user with that email");
	        }
		return new LoginUser(user);
	}

}
