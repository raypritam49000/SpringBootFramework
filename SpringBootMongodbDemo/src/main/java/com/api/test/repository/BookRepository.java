package com.api.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.test.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer>{

}
