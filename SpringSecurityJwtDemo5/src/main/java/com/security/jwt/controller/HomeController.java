package com.security.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.security.jwt.model.AuthenticationRequest;
import com.security.jwt.model.AuthenticatonResponse;
import com.security.jwt.utilclass.JwtTokenUtil;

@RestController
public class HomeController {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService myUserDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@RequestMapping("/home")
	public String home() {
		return "Hello Pritam Ray";
	}
	
	@RequestMapping(value = "/authenticate",method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenicationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		
		try 
		{
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
		} 
		catch (BadCredentialsException e) 
		{
			throw new Exception("Incorrect Username and Password",e);
		}
		
		 final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		 
		 final String jwt = this.jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticatonResponse(jwt));
	}
}
