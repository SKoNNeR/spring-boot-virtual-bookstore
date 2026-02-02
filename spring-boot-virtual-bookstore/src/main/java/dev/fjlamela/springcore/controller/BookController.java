package dev.fjlamela.springcore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fjlamela.springcore.controller.dto.CreateBookRequest;
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
	
	@PostMapping
	public ResponseEntity<Void> createBook(@RequestBody CreateBookRequest request) {
		String title= request.getTitle();
		String author= request.getAuthor();
		String isbn= request.getIsbn();
		int publicationYear= request.getPublicationYear();
		
		Book newBook= new Book(title, author, isbn, publicationYear);
		
		bookService.addBook(newBook);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
