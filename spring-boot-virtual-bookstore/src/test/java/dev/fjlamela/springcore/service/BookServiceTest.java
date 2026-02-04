package dev.fjlamela.springcore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dev.fjlamela.springcore.domain.Book;
import dev.fjlamela.springcore.repository.inmemory.InMemoryBookRepository;
import dev.fjlamela.springcore.service.exception.DuplicateBookException;

public class BookServiceTest {
	
	@Test
	public void addBook_shouldStoreBook() {
		InMemoryBookRepository memBook= new InMemoryBookRepository();
		BookService bookService= new BookService(memBook);
		Book book= new Book("The Old Man and the Sea", "Ernest Hemingway", "978-0684801223", 1952);
		bookService.addBook(book);
		
		Book bookByIsbn= bookService.getBookByIsbn("978-0684801223");
		
		Assertions.assertNotNull(bookByIsbn);
		Assertions.assertEquals(book, bookByIsbn);		
		
	}
	
	@Test
	public void addBook_shouldThrowWhenDuplicateIsbn() {
		InMemoryBookRepository memBook= new InMemoryBookRepository();
		BookService bookService= new BookService(memBook);
		Book book= new Book("The Old Man and the Sea", "Ernest Hemingway", "978-0684801223", 1952);
		Book book2= new Book("The Old Man and the Sea", "Ernest Hemingway", "978-0684801223", 1952);
		bookService.addBook(book);
		
		Assertions.assertThrows(DuplicateBookException.class, ()-> {			
			bookService.addBook(book2);
		});
	}
	
	@Test
	public void getBookByIsbn_shouldThrowWhenNotFound() {
		
	}
	
}
