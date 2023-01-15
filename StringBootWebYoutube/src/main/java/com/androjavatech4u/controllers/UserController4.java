package com.androjavatech4u.controllers;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class UserController4 
{
//http://localhost:8081/getuser/1/surya
 
	
@GetMapping(value = "/getuser/{idd}/{name}")	
public String getUserData(@PathVariable("idd") int id, @PathVariable String name)
{
	System.out.println(id +" "+name);
	   return "home";
}
 
}
