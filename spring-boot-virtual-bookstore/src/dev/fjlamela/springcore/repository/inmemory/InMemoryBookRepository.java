package dev.fjlamela.springcore.repository.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.fjlamela.springcore.domain.Book;
import dev.fjlamela.springcore.repository.BookRepository;

@Repository
public class InMemoryBookRepository implements BookRepository {
	
	private Map<String, Book> books= new HashMap<>();
	
	
	@Override
	public Book save(Book book) {
		books.put(book.getIsbn(), book);
		return book;
	}

	@Override
	public Optional<Book> findByIsbn(String isbn) {
		return Optional.ofNullable(books.get(isbn));
	}

	@Override
	public void deleteByIsbn(String isbn) {
		if (books.containsKey(isbn)) books.remove(isbn);
	}

	@Override
	public List<Book> findAll() {
		List<Book> bookList= new ArrayList<>();
		for (Book book: books.values()) {
			bookList.add(book);
		}
		return bookList;
	}

}
