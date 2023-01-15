package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
public class MyCustAuthProvider implements AuthenticationProvider{
  
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// authenticate the authentication user request
		// throws AuthenticationException
		// return null
		
		//User Input Credentials
		String password = (String)authentication.getCredentials();
		
		// fetch record from database
		UserDetails user = this.userDetailsService.loadUserByUsername(authentication.getName());
		
		if(user!=null && passwordEncoder.matches(password,user.getPassword())) {
		 return	new UsernamePasswordAuthenticationToken
			(authentication.getName(),authentication.getCredentials().toString());
		}
		
		
		return null ;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
