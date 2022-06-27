package com.demo.controller;

import com.demo.model.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@RestController
public class HomeController {
@Autowired
private UserService userService;

    @RequestMapping(value = "/home")
    public String home(Model model){
        model.addAttribute("title","Home");
        return "home";
    }


    @RequestMapping(value = "/about")
    public String about(Model model){
        model.addAttribute("title","about");
        return "about";
    }

    @RequestMapping(value = "/register")
    public String register(Model model){
        model.addAttribute("title","register");
        return "register";
    }

    @RequestMapping(value = "/do_register",method = RequestMethod.POST)
    public String do_register(@ModelAttribute("user") User user,Model model){
        model.addAttribute("user",user);
        return "register";
    }
}
