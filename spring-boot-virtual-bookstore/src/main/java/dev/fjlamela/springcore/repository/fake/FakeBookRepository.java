package dev.fjlamela.springcore.repository.fake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.fjlamela.springcore.domain.Book;
import dev.fjlamela.springcore.repository.BookRepository;

@Repository
public class FakeBookRepository implements BookRepository {
	
	private Map<String, Book> bookMap= new HashMap<>();
	
	@Override
	public Book save(Book book) {
		bookMap.put(book.getIsbn(), book);
		return book;
	}

	@Override
	public Optional<Book> findByIsbn(String isbn) {
		return Optional.ofNullable(bookMap.get(isbn));
	}

	@Override
	public void deleteByIsbn(String isbn) {
		if (bookMap.containsKey(isbn)) bookMap.remove(isbn);

	}

	@Override
	public List<Book> findAll() {
		List<Book> bookList= new ArrayList<>();
		for (Book book: bookMap.values()) {
			bookList.add(book);
		}
		return bookList;
	}

}
