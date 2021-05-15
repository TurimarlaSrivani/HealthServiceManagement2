package com.hsm.healthservicemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hsm.healthservicemanagement.entity.PatientHistoryErrorResponse;

@ControllerAdvice
public class PatientHistoryExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<PatientHistoryErrorResponse> handleException(PatientHistoryNotFoundException exception)
	{
		PatientHistoryErrorResponse error= new PatientHistoryErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<PatientHistoryErrorResponse> handleException(Exception exception)
	{
		PatientHistoryErrorResponse error= new PatientHistoryErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	

}
