package dev.fjlamela.springcore.domain;

import java.time.Year;

public class Book {
	
	private String title;
	private String author;
	private String isbn;
	private int publicationYear;
	
	public Book(String title, String author, String isbn, int publicationYear) {
		if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("ERROR: Title cannot be NULL or EMPTY");
		if (author == null || author.trim().isEmpty()) throw new IllegalArgumentException("ERROR: Author cannot be NULL or EMPTY");
		if (isbn == null || isbn.trim().isEmpty() || isbn.trim().length() < 13 || isbn.trim().length() > 17) throw new IllegalArgumentException("ERROR: ISBN cannot be NULL or EMPTY, and must be between 13 and 17 chars");
		if (publicationYear <= 1450 || publicationYear > Year.now().getValue()) throw new IllegalArgumentException("ERROR: Publication year must be between 1450 ~ " + Year.now().getValue());
		
		this.title= title;
		this.author= author;
		this.isbn= isbn;
		this.publicationYear= publicationYear;
	}

	public String getIsbn() {
		return isbn;
	}
	
	@Override
	public String toString() {
		return "Title: " + title + " | Author: " + author + " | Publication Year: " + publicationYear + " | ISBN: " + isbn; 
	}
}
