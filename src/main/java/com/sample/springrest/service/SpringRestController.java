package com.sample.springrest.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.springrest.exception.InvalidIdException;
import com.sample.springrest.exception.InvalidNameException;
import com.sample.springrest.model.Errors;
import com.sample.springrest.model.SampleSpringRestRequest;
import com.sample.springrest.model.SampleSpringRestResponse;

@RestController
@RequestMapping("/v1")
public class SpringRestController {
	
	@RequestMapping(path="/sampleRest", method = RequestMethod.POST)
	public SampleSpringRestResponse  getName(@RequestBody SampleSpringRestRequest req) throws Exception{
		
		SampleSpringRestResponse resp = new SampleSpringRestResponse();
		
		
			if(req.getId() == 2) {
				throw new InvalidIdException("This is the error message thrown by controller");
			}
			if(req.getName().equalsIgnoreCase("Subba")) {
				throw new InvalidNameException("This is the error message thrown by controller");
			}
		
		resp.setMessage(req.getName() + ":" + req.getId());
		resp.setStatusCode(200);
		
		return resp;
	}
	
	@ExceptionHandler(InvalidIdException.class)
	public Errors handleInvalidIdException(HttpServletRequest httpReq, InvalidIdException e){
		
		Errors error = new Errors(400, e.getMessage()+" and message added in the exception handler method" );
		return error;
		
		//return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
		
	}

}
