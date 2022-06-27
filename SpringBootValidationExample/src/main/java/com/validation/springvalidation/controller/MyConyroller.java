package com.validation.springvalidation.controller;

import javax.validation.Valid;

import com.validation.springvalidation.model.LoginData;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyConyroller {

    @RequestMapping("/form")
    public String home(Model m) {
        System.out.println("Form Handler....");
        m.addAttribute("loginData", new LoginData());
        return "form";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result) {

        if (result.hasErrors()) {
            System.out.println(result);
            return "form";
        }
        else 
        {
        	 System.out.println(loginData.getUserName() + " " + loginData.getEmail());
             return "success";
        }
        
    }
}
