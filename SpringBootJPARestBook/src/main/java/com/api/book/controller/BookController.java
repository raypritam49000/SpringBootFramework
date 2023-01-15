package com.api.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.model.Book;
import com.api.book.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		System.out.println("Get All Books...");
		List<Book> list = this.bookService.getAllBooks();
		if(list.size()<=0) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else 
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}
	}
	
	@GetMapping("/bookById/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
		System.out.println("Get Book By Id...");
		Book book = this.bookService.getBookById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		System.out.println("Add Book...");
		Book b = null;
		try 
		{
		   b = this.bookService.addBook(book);	
		   return ResponseEntity.of(Optional.of(b));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	 }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
		try
		{
			this.bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("id") int id) {
		try 
		{
			this.bookService.updateBook(book,id);
			return ResponseEntity.ok().body(book);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	 
	}
}
