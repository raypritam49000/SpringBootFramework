package com.jersey.webseries.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jersey.webseries.model.User;
import com.jersey.webseries.repository.UserRespository;
import com.sun.istack.NotNull;

@Service
@Path("/hello")
public class UserService {
	@Autowired
	private UserRespository userRespository;

	@GET
    @Produces("text/plain")
    public String reverse(@QueryParam("data") @NotNull String data) {
        return new StringBuilder(data).reverse().toString();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/save")
    public String saveUser(User user) {
    	this.userRespository.save(user);
    	return "User are Saved....";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/allUser")
    public List<User> getAllUser(){
    	List<User> users = this.userRespository.findAll();
    	return users;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/userById/{id}")
    public User getUserById(@PathParam("id") int id) {
      return this.userRespository.findById(id).get();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteUserById/{id}")
    public String deleteUserById(@PathParam("id") int id) {
    	this.userRespository.deleteById(id);
    	return "User are delete success...";
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/saveAllUsers")
    public String saveAllUser(List<User> users) {
    	this.userRespository.saveAll(users);
    	return "Users are Saved....";
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteAllUser")
    public String deleteAllUser() {
    	this.userRespository.deleteAll();
    	return "All Users are Delete Successfully";
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateUser/{id}")
    public String updateUser(@PathParam("id") int id,User user) {
    	user.setId(id);
    	this.userRespository.save(user);
    	return "User are update Successfully";
    }
    
}