package com.sample.springrest.exception;

public class InvalidNameException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1878063372142072223L;

	public InvalidNameException() {
		super();
	}
	
	public InvalidNameException(String message) {
		
		super(message);
		
	}

}
