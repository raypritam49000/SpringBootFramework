package com.androjavatech4u.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.androjavatech4u.vo.User;

@org.springframework.stereotype.Service
public class Service 
{

	private final RestTemplate restTemplate;
	
	@Autowired
	public Service(RestTemplate restTemplate)
	{
	this.restTemplate=restTemplate;	
	}
	
	public User consumeAPI()
	{
		return restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1",User.class);
	}
	

}
