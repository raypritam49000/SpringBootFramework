package com.springboot.mvc.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mvc.test.models.User;

@Repository
public interface UserRespository extends CrudRepository<User, Integer> {
	public User findUserById(int id);
	public User findUserByMobile(String mobile);
}
