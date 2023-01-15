package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findUserByUsername(String name);
}
