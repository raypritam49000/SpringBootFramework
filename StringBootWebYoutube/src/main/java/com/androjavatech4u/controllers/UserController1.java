package com.androjavatech4u.controllers;
 
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.androjavatech4u.entities.User;

@Controller
public class UserController1 
{

@RequestMapping(value = "/register11", method = RequestMethod.GET)	
public ModelAndView  doLogin(String name,String email,String pass,String mobile)
{
 
//User user=new User();
//user.setEmail(email);
//user.setMobile(mobile);
//user.setName(name);
//user.setPass(pass);
	
HashMap hashMap=new HashMap();
hashMap.put("name1",name);
hashMap.put("email1",email);
hashMap.put("pass1",pass);
hashMap.put("mobile1",mobile);
//
//model.addAllAttributes(hashMap);

//ModelAndView modelAndView=new ModelAndView("home",hashMap);

//modelAndView.addAllObjects(hashMap);

//
//modelAndView.addObject("name1",name);
//modelAndView.addObject("pass1",pass);

//modelAndView.setViewName("home");

//model.addAttribute("name1",name);
//model.addAttribute("email1",email);
//model.addAttribute("mobile1",mobile);
//model.addAttribute("pass1",pass);

return new ModelAndView("home",hashMap);
}
 

}
