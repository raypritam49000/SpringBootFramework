package com.springboot.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
   
	@RequestMapping("/")
	public String home() {
		System.out.println("Hello");
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/about")
	public String about() {
		return "Hello About Page";
	}
	
	@RequestMapping("/service")
	public String srvice() {
		return "service";
	}
}
