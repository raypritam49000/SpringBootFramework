package com.jersey.webseries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jersey.webseries.model.User;

@Repository
public interface UserRespository extends JpaRepository<User, Integer>{

}
