package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping("/")
	@ResponseBody
	private String home() {
		return "<h1>Hello,Home Page<h1>";
	}

	@RequestMapping("/admin")
	@ResponseBody
	private String admin() {
		return "<h1>Hello,Admin Page<h1>";
	}

	@RequestMapping("/user")
	@ResponseBody
	private String user() {
		return "<h1>Hello,User Page<h1>";
	}

}
