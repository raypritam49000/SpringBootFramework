package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.security.models.User;
import com.security.service.UserService;

@Controller
public class HomeController {
    
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="/createUser",method = RequestMethod.POST)
	private String save(@RequestBody User user) {
		 this.userService.addUser(user);
		 return "user save success....";
	}
}
