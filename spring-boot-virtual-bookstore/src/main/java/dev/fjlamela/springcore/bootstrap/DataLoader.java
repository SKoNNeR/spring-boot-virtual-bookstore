package dev.fjlamela.springcore.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.fjlamela.springcore.domain.Book;
import dev.fjlamela.springcore.service.BookService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final BookService bookService;
	
	public DataLoader(BookService bookService) {
		this.bookService= bookService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		bookService.addBook(new Book("The Hobbit", "J. R. R. Tolkien", "9780547928227", 1937));
		bookService.addBook(new Book("The Fellowship of the Ring", "J. R. R. Tolkien", "9780547928210", 1954));
		bookService.addBook(new Book("The Silmarillion", "J. R. R. Tolkien", "9780618126989", 1977));
	}

}
