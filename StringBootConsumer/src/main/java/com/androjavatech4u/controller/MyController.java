package com.androjavatech4u.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.androjavatech4u.service.Service;
import com.androjavatech4u.vo.User;

@RestController
public class MyController {

private final Service service;

@Autowired
public MyController(Service service)
{
	this.service=service;	
}

@GetMapping
public ResponseEntity<User> getData()
{
return new ResponseEntity<>(service.consumeAPI(),HttpStatus.OK);	
}
	
}
