package com.androjavatech4u.controllers;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class UserController2 
{
	
@GetMapping(value = "/register")	
public String doLogin(String name,String email,String pass,String mobile,Map<String, String> map)
{		
map.put("name",name);
map.put("email",email);
map.put("mobile",mobile);
map.put("pass",pass);
return "home";
}

@GetMapping(value = "/register23")	
public String doLogin1(String name,String email,String pass,String mobile,Model map)
{		
map.addAttribute("name",name);
map.addAttribute("email",email);
map.addAttribute("mobile",mobile);
map.addAttribute("pass",pass);
return "home";
}

@RequestMapping(value = "/register24", method = RequestMethod.GET)	
public String doLogin2(String name,String email,String pass,String mobile,ModelMap map)
{	
map.put("name",name);
map.put("email",email);
map.put("mobile",mobile);
map.put("pass",pass);
//map.addAttribute(map);
return "home";
}

@RequestMapping(value = "/register25", method = RequestMethod.GET)	
public ModelAndView doLogin2(String name,String email,String pass,String mobile,Map<String, String> map)
{	
map.put("name",name);
map.put("email",email);
map.put("mobile",mobile);
map.put("pass",pass);
ModelAndView modelAndView=new ModelAndView("home");	
modelAndView.addObject(map);
return modelAndView;
}

}
