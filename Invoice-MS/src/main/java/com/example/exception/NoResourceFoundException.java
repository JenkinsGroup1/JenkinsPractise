package com.example.exception;

public class NoResourceFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoResourceFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NoResourceFoundException(String errors) {
		super(errors);
		// TODO Auto-generated constructor stub
	}

}
