package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public List<User> findByName(String name);

	public User findByNameAndCity(String name, String city);

	public List<User> findByNameOrCity(String name, String city);

	public List<User> findByIdBetween(int start, int end);

	public List<User> findByIdLessThan(int id);

	public List<User> findByIdGreaterThan(int id);

	public List<User> findByNameStartingWith(String name);

	@Query("select u From User u")
	public List<User> getAllUsers();

	@Query("select u from User u Where u.name =:n")
	public List<User> getUserByName(@Param("n") String name);
	
	@Query("select u from User u Where u.name =:n and u.city =:c")
	public List<User> getUserByNameAndCity(@Param("n") String name,@Param("c") String city);

	@Query(value = "select * from user",nativeQuery = true)
	public List<User> getUsers();
}
