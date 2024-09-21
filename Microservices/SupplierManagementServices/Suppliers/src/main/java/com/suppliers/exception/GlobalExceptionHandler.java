package com.suppliers.exception;

import java.sql.Date;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value= {NullPointerException.class})
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	 protected ResponseEntity<Object> errorHandler(NullPointerException e, WebRequest req){
		
		ErrorResponse error = new ErrorResponse();
		 error.setMessage(e.getMessage());
		 error.setErrorCode("406");
		 error.setTime(new java.util.Date());
		
		 return handleExceptionInternal(e,error,new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE,req);
	 
	 }
	
    @ExceptionHandler(value= {ValidationException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<Object> errorHandler(ValidationException e, WebRequest req){
		 ErrorResponse error = new ErrorResponse();
		 error.setMessage(e.getMessage());
		 error.setErrorCode("404");
		 error.setTime(new java.util.Date());
		 return handleExceptionInternal(e,error,new HttpHeaders(),HttpStatus.BAD_REQUEST,req);
		 
}
	@ExceptionHandler(value= {Exception.class})

	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	 protected ResponseEntity<Object> errorHandler(Exception e, WebRequest req){
		 ErrorResponse error = new ErrorResponse();
		 error.setMessage(e.getMessage());
		 error.setErrorCode("406");
		 error.setTime(new java.util.Date());
		 return handleExceptionInternal(e,error,new HttpHeaders(),
				 HttpStatus.NOT_ACCEPTABLE,req);
		 
}

}
