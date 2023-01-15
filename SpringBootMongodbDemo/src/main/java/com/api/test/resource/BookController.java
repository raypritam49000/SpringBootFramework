package com.api.test.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.test.model.Book;
import com.api.test.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		System.out.println("Save Book...");
		this.bookRepository.save(book);
		return "Added Book with id : " + book.getId();
    }
	
	@GetMapping("/findAllBooks")
	public List<Book> getBooks(){
		System.out.println("Get All Books...");
		List<Book> books = this.bookRepository.findAll();
		return books;
	}
	
	@GetMapping("/findBookById/{id}")
	public Optional<Book> getBook(@PathVariable("id") int id){
		System.out.println("Get Book By Id...");
		return this.bookRepository.findById(id);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		System.out.println("Delete Book By id...");
	   this.bookRepository.deleteById(id);
	   return "book delete by id : "+id;
	}
}
