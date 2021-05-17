package com.hsm.healthservicemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hsm.healthservicemanagement.entity.FinanceErrorResponse;

@ControllerAdvice
public class FinanceExceptionHandler {

	// Create method to handle exception
	@ExceptionHandler
	public ResponseEntity<FinanceErrorResponse> handleException(FinanceNotFoundException exception) {
		FinanceErrorResponse error = new FinanceErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<FinanceErrorResponse> handleException(Exception exception) {
		FinanceErrorResponse error = new FinanceErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Bad Request");
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
