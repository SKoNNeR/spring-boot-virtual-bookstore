package dev.fjlamela.springcore.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.fjlamela.springcore.config.AppConfig;
import dev.fjlamela.springcore.domain.Book;
import dev.fjlamela.springcore.service.BookService;

public class MainApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		BookService bookService= context.getBean(BookService.class);
		bookService.addBook(new Book("EL SEÑOR DE LOS ANILLOS 1. LA COMUNIDAD DEL ANILLO", "J. R. R. Tolkien", "9788445018057", 2024));
		bookService.addBook(new Book("EL SEÑOR DE LOS ANILLOS 2. LAS DOS TORRES", "J. R. R. Tolkien", "9788445018064", 2024));
		bookService.addBook(new Book("EL CÍRCULO DE LOS DÍAS", "Ken Follett", "9788401036811", 2025));
		
		for (Book book: bookService.listBooks()) {
			System.out.println(book.toString());
		}
		
		context.close();
	}
}
