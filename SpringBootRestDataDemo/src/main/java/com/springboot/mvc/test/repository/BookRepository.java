package com.springboot.mvc.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.mvc.test.model.Book;

@RepositoryRestResource(path = "mybooks",collectionResourceRel = "allbooks")
public interface BookRepository extends JpaRepository<Book, Integer>{

}
