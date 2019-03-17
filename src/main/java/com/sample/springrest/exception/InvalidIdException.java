package com.sample.springrest.exception;

public class InvalidIdException extends Exception{
	
	  /**
	 *   
	 */
	private static final long serialVersionUID = 1L;

	public InvalidIdException() {
		  super("Invalid Id exception occured");
	  }
	  
	  public InvalidIdException(String message) {
		  super(message);
	  }

}
