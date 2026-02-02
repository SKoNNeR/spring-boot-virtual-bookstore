package dev.fjlamela.springcore.controller.dto;

public class CreateBookRequest {
	private String title;
	private String author;
	private String isbn;
	private int publicationYear;
	
	public CreateBookRequest() {
		super();
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
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	
}
