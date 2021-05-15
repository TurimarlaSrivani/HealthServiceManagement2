package com.hsm.healthservicemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hsm.healthservicemanagement.*;
import com.hsm.healthservicemanagement.entity.PatientCaseErrorResponse;

@ControllerAdvice
public class PatientCaseExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<PatientCaseErrorResponse>handleException(PatientCaseNotFoundException exception)
	{
		PatientCaseErrorResponse  error = new PatientCaseErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<PatientCaseErrorResponse>handleException(Exception exception)
	{
		PatientCaseErrorResponse  error = new PatientCaseErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}

}
