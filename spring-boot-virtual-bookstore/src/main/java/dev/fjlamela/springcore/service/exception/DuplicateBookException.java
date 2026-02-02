package dev.fjlamela.springcore.service.exception;

public class DuplicateBookException extends RuntimeException {
	public DuplicateBookException(String errorMessage) {
		super(errorMessage);
	}
}
