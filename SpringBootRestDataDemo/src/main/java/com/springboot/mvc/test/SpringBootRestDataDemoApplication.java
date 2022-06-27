package com.springboot.mvc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.mvc.test.model.Book;
import com.springboot.mvc.test.repository.BookRepository;

@SpringBootApplication
public class SpringBootRestDataDemoApplication implements CommandLineRunner{
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
    
		Book book1 = new Book("First Book","First Content",20);
		Book book2 = new Book("Second Book","Second Content",40);
		
		this.bookRepository.save(book1);
		this.bookRepository.save(book2);
		
	}

}
