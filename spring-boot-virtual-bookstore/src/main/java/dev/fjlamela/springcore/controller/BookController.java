package dev.fjlamela.springcore.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.fjlamela.springcore.controller.dto.BookResponse;
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
	public List<BookResponse> getBooks(){
		List<Book> bookList= bookService.listBooks();
		List<BookResponse> bookResponse= new ArrayList<>();
		for (Book book: bookList) {
			bookResponse.add(new BookResponse(book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublicationYear()));
		}
		return bookResponse;
	}
	
	@PostMapping
	public ResponseEntity<BookResponse> createBook(@RequestBody CreateBookRequest request) {
		String title= request.getTitle();
		String author= request.getAuthor();
		String isbn= request.getIsbn();
		int publicationYear= request.getPublicationYear();
		
		Book newBook= new Book(title, author, isbn, publicationYear);
		
		bookService.addBook(newBook);
		
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{isbn}").buildAndExpand(newBook.getIsbn()).toUri(); 
				
		return ResponseEntity.created(location).body(new BookResponse(newBook.getTitle(), newBook.getAuthor(), newBook.getIsbn(), newBook.getPublicationYear()));
	}

}
