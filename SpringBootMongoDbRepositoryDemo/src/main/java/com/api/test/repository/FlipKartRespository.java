package com.api.test.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.test.model.User;

@Repository
public interface FlipKartRespository extends MongoRepository<User, Integer> {
	public List<User> findByName(String name);

	@Query("{'Address.city'=?0}")
	public List<User> findByAddress(@RequestParam(value="city") String city);
}
