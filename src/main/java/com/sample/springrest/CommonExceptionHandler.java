package com.sample.springrest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sample.springrest.exception.InvalidNameException;
import com.sample.springrest.model.Errors;

@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity<Errors> handleInvalidNameException(HttpServletRequest req, Exception e) {
		
		Errors errors = new Errors(400,e.getMessage() + "and handled in global exception handler");
		return new ResponseEntity<Errors>(errors, HttpStatus.BAD_REQUEST);
		
	}

}
