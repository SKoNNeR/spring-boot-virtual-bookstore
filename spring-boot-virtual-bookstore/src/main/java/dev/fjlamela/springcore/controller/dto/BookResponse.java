package dev.fjlamela.springcore.controller.dto;

public class BookResponse {
	
	private String title;
	private String author;
	private String isbn;
	private int publicationYear;
	
	public BookResponse(String title, String author, String isbn, int publicationYear) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPublicationYear() {
		return publicationYear;
	}
	
}
