package com.api.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.book.model.Book;

@Service
public class BookService {

	public static List<Book> list = new ArrayList<Book>();

	static {
		list.add(new Book(1, "Java Book", "Pritam Ray"));
		list.add(new Book(2, "JavaScript Book", "Omi Verma"));
		list.add(new Book(3, "PHP Book", "RD Sharma"));
		list.add(new Book(4, "Angular Book", "Chandan Kumar"));
	}

	// Get All Books
	public List<Book> getAllBooks() {
		return list;
	}

	// Get Book By Id
	public Book getBookById(int id) {
		Book book = null;
		try 
		{
		 book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return book;
	}

	// Add Book
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}

	// Delete Book
	public void deleteBook(int bid) {
		list = list.stream().filter(book -> {
			if (book.getId() != bid) {
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList());
	}
	
	// Update Book
	 
	public void updateBook(Book book,int id) {
		list = list.stream().map(b->{
			if(b.getId()==id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
}
