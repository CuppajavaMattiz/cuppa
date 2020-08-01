package com.mattiz.springboot.basics.springbootmattiz;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionStructure exceptionStructure = new  ExceptionStructure(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(exceptionStructure,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(BookNotFoundException.class)
	protected ResponseEntity<Object> handleUserNotFoundExceptions(BookNotFoundException ex, WebRequest request) {
		ExceptionStructure exceptionStructure = new  ExceptionStructure(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(exceptionStructure,HttpStatus.NOT_FOUND);
	}


	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionStructure exceptionStructure = new  ExceptionStructure(new Date(), "Title should be greater than 2 less than 10.", ex.getBindingResult().toString());
		return super.handleMethodArgumentNotValid(ex, headers, HttpStatus.BAD_REQUEST, request);
	}

	

}
