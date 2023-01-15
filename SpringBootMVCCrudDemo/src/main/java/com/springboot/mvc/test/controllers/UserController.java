package com.springboot.mvc.test.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.springboot.mvc.test.models.User;
import com.springboot.mvc.test.services.UserServiceImpl;

@Controller
public class UserController {
 
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/")
	public String home(ModelMap map) {
		List<User> users = this.userServiceImpl.findAllUser();
		map.addAttribute("users", users);
		return "home";
	}
	
	@RequestMapping("/addUser")
	public String addView() {
	  return "index";	
	}
	
	
	@RequestMapping(path="delete/{id}")
	public RedirectView deleteUser(@PathVariable("id") int id,HttpServletRequest request) {
		this.userServiceImpl.deleteUserById(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping(value="update/{id}")
	public String updateUser(@PathVariable("id") int id,Model model) {
		User user = this.userServiceImpl.findUserById(id);
		model.addAttribute("user", user);
		return "update";
	}
	
	@RequestMapping(path = "/addLogic",method = RequestMethod.POST)
	public RedirectView addUser(@ModelAttribute User user,HttpServletRequest request) {
		this.userServiceImpl.saveUser(user);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
}
