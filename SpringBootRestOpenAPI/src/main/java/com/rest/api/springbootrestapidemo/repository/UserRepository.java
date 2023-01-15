package com.rest.api.springbootrestapidemo.repository;

import com.rest.api.springbootrestapidemo.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
   public User findUserByName(String name);
   public User findUserByNameAndCity(String name,String city); 
}
