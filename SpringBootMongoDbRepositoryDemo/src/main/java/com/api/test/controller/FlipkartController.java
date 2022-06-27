package com.api.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.test.model.User;
import com.api.test.repository.FlipKartRespository;

@RestController
public class FlipkartController {

	@Autowired
	private FlipKartRespository flipKartRespository;
	
	@PostMapping("/placeOrderNow")
	public String placeOrder(@RequestBody User user) {
		this.flipKartRespository.save(user);
		return "Order placed successfully";
	}
	
	@GetMapping("/findByName/{name}")
	public List<User> getUserByName(@PathVariable("name") String name){
	  	return this.flipKartRespository.findByName(name);
	}
	
	@GetMapping("/findByName/{city}")
	public List<User> getUserByAddress(@PathVariable("city") String city){
		return this.flipKartRespository.findByAddress(city);
	}
}
