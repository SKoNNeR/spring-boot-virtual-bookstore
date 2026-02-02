package dev.fjlamela.springcore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fjlamela.springcore.domain.Book;
import dev.fjlamela.springcore.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService= bookService;
	}
	
	@GetMapping
	public List<Book> getBooks(){
		return bookService.listBooks();
	}

}
