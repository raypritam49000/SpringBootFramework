package com.springboot.practice.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	// handler for iteration
	@RequestMapping(path = "/about",method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("In Side About Handler");
		model.addAttribute("name","Pritam Ray");
		model.addAttribute("currentDate",new Date().toLocaleString());
		List<String> friends = Arrays.asList("Pritam","Raj","Ram","Amit","Omi");
		model.addAttribute("names", friends);
		return "about";
	}
	
	//handler for conditional statement
	@RequestMapping("/condition")
	public String conditionHandler(Model m) {
		System.out.println("Conditional Handler.....");
		m.addAttribute("isActive",true);
		m.addAttribute("Gender", "M");
		List<Integer> nums=Arrays.asList(20,43,21,86,343,232);
		m.addAttribute("myList", nums);
		return "condition";
	}
	
	// handler for insert/include/replace
	@RequestMapping("/service")
	public String services(Model m) {
		System.out.println("Service Handler....");
		m.addAttribute("title","This is Title");
		m.addAttribute("subtitle","This is Title");
		return "service";
	}
	
	// handler for new about
	@RequestMapping("/newabout")
	public String newAbout(Model m) {
		System.out.println("New About Handler....");
		return "aboutnew";
	}
	
	// handler for contact
		@RequestMapping("/contact")
		public String contact(Model m) {
			System.out.println("Contact Handler....");
			return "contact";
		}
	
}
