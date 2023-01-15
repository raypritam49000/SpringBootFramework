package com.api.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.api.book.dao.BookRepository;
import com.api.book.model.Book;

@Service
public class BookService {

	@Autowired
	//@Qualifier("bookRepository")
	private BookRepository bookRepository;

	// Get All Books
	public List<Book> getAllBooks() {
		List<Book> books = (List<Book>) this.bookRepository.findAll();
		return books;
    }

	// Get Book By Id
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = this.bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// Add Book
	public Book addBook(Book book) {
		// list.add(book);
		Book result = this.bookRepository.save(book);
		return result;
	}

	// Delete Book
	public void deleteBook(int bid) {
		this.bookRepository.deleteById(bid);
	}
	
	// Update Book
    public void updateBook(Book book, int id) {
    	book.setId(id);
        this.bookRepository.save(book);
	}
}
