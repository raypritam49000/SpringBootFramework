package com.androjavatech4u.controllers;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class UserController3 
{

@Value("${id.name:Surya Praksh Tripathi}")
private String app;
	
@PostMapping(value = "/registerUser")	
public String doRegister(@RequestParam("name") String name1,
		@RequestParam("email") String email1,
		@RequestParam("mobile") String mobile1,
		@RequestParam("pass") String pass1,Model model)
{
	model.addAttribute("name",name1);
	model.addAttribute("email",email1);
	model.addAttribute("mobile",mobile1);
	model.addAttribute("pass",pass1);	
    return "home";
}


@PostMapping(value = "/registerUser1")	
public String doRegister1(@RequestParam String name,
		@RequestParam String email,
		@RequestParam String mobile,
		@RequestParam String pass,Model model)
{
	model.addAttribute("name",name);
	model.addAttribute("email",email);
	model.addAttribute("mobile",mobile);
	model.addAttribute("pass",pass);
	 	
return "home";
}
}
