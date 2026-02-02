package dev.fjlamela.springcore.repository;

import java.util.List;
import java.util.Optional;

import dev.fjlamela.springcore.domain.Book;

public interface BookRepository {
	public Book save(Book book);
	public Optional<Book> findByIsbn(String isbn);
	public void deleteByIsbn(String isbn);
	public List<Book> findAll();
}
