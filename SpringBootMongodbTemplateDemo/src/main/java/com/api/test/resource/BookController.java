package com.api.test.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.test.model.Book;

@RestController
public class BookController {

	@Autowired
	private MongoTemplate mongoTemplate;

	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		System.out.println("Save Book...");
		this.mongoTemplate.save(book);
		return "Added Book with id : " + book.getId();
	}

	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		System.out.println("Get All Books...");
		List<Book> books = this.mongoTemplate.findAll(Book.class, "book");
		return books;
	}

	@GetMapping("/findBookById/{id}")
	public Book getBook(@PathVariable("id") int id) {
		System.out.println("Get Book By Id...");
		return this.mongoTemplate.findById(id, Book.class);
	}

	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		System.out.println("Delete Book By id...");
		Book book = this.mongoTemplate.findById(id, Book.class);
		this.mongoTemplate.remove(book);
		return "book delete by id : " + id;
	}
}
