package com.hibernate.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.test.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
