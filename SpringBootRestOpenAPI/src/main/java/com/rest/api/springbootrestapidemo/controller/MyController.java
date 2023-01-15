package com.rest.api.springbootrestapidemo.controller;

import java.util.List;
import java.util.Optional;

import com.rest.api.springbootrestapidemo.model.User;
import com.rest.api.springbootrestapidemo.service.UserServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@Operation(summary = "Create User in DB")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "Create The User in DB",
					content = {@Content(mediaType = "Application/json")}),
			

    		@ApiResponse(responseCode = "404",
			description = "User Not Available",
			content = @Content)
	})
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		 this.userServiceImpl.saveUser(user);
		 return user;
	}
	
	@Operation(summary = "This is to fetch USER using id in DB")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "Fetch the USER using id from DB",
					content = {@Content(mediaType = "Application/json")}),
			

    		@ApiResponse(responseCode = "404",
			description = "User Not Available",
			content = @Content)
	})
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") int id) {
		User user = null;
		try 
		{
			user = this.userServiceImpl.getUserById(id);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(user));
	}

	@Operation(summary = "This is to fetch All the USER store in DB")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200",
    				description = "Fetch All the USER from DB",
    				content = {@Content(mediaType = "application/json")}),
    		
    		@ApiResponse(responseCode = "404",
			description = "Not Available",
			content = @Content)
    })
	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
       return this.userServiceImpl.getAllUser();
	}

	@Operation(summary = "The update USER using by id in DB")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200",
    				description = "Update USER using by id",
    				content = {@Content(mediaType = "application/json")}),
    		
    		@ApiResponse(responseCode = "404",
			description = "Not Available",
			content = @Content)
    })
	@PutMapping("/update/{id}")
	public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
		this.userServiceImpl.updateUserById(user, id);
		return user;
	}

	
	@Operation(summary = "The delete USER using by id in DB")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200",
    				description = "Delete USER using by id",
    				content = {@Content(mediaType = "application/json")}),
    		
    		@ApiResponse(responseCode = "404",
			description = "Not Available",
			content = @Content)
    })
	@DeleteMapping("/delete/{id}")
	public String deleteUserById(@PathVariable("id") int id) {
		this.userServiceImpl.deleteUserById(id);
		return "User are delete Successfully";
	}

	
	@Operation(summary = "The Save All USER in DB")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200",
    				description = "Save All USER in DB",
    				content = {@Content(mediaType = "application/json")}),
    		
    		@ApiResponse(responseCode = "404",
			description = "Not Available",
			content = @Content)
    })
	@PostMapping("/allUserSave")
	public String saveAllUser(@RequestBody List<User> list) {
		this.userServiceImpl.saveAllUser(list);
		return "Save All User Successfully...";
	}
	
    
	@Operation(summary = "The Delete All USER in DB")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200",
    				description = "Delete All USER in DB",
    				content = {@Content(mediaType = "application/json")}),
    		
    		@ApiResponse(responseCode = "404",
			description = "Not Available",
			content = @Content)
    })
	@DeleteMapping("/allUserDelete")
	public String deleteAllUser(@RequestBody List<User> list) {
		this.userServiceImpl.deleteAllUser(list);
		return "All User are delete Successfully ...";
	}

	
	@Operation(summary = "This is to fetch USER using name in DB")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "Fetch the USER using name from DB",
					content = {@Content(mediaType = "Application/json")}),
			

    		@ApiResponse(responseCode = "404",
			description = "User Not Available",
			content = @Content)
	})
	@GetMapping("getUserbyName/{name}")
	public User getUserByName(@PathVariable("name") String name) {
		return this.userServiceImpl.getUserByName(name);
	}

	
	@Operation(summary = "This is to fetch USER using name and city in DB")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "Fetch the USER using name and city from DB",
					content = {@Content(mediaType = "Application/json")}),
			

    		@ApiResponse(responseCode = "404",
			description = "User Not Available",
			content = @Content)
	})
	@GetMapping("/getUserByNameAndCity/{name}/{city}")
	public ResponseEntity<User> getUserByNameAndCity(@PathVariable("name") String name,
			@PathVariable("city") String city) {
		User user = this.userServiceImpl.getUserByNameandCity(name, city);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.of(Optional.of(user));
	}
}
