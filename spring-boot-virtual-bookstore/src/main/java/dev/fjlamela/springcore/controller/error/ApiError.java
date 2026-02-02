package dev.fjlamela.springcore.controller.error;

public class ApiError {
	private int status;
	private String error;
	private String message;
	public ApiError(int status, String error, String message) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public String getError() {
		return error;
	}
	public String getMessage() {
		return message;
	}
}
