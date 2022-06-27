package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping("/")
	@ResponseBody
	private String home() {
		return "<h1>This is Home Page</h1>";
	}
	
}
