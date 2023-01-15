package com.hibernate.test.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.test.model.User;

@Repository
public class UserDao {
	@Autowired
	private EntityManager entityManager;

	@Transactional
	public void addUser(User user) {
		try {
			entityManager.persist(user);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
