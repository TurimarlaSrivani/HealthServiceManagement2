package com.hsm.healthservicemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hsm.healthservicemanagement.controller.TreatmentErrorResponse;

@ControllerAdvice
public class TreatmentExceptionHandler {

	// Create method to handle exception
	@ExceptionHandler
	public ResponseEntity<TreatmentErrorResponse> handleException(TreatmentNotFoundException exception) {
		TreatmentErrorResponse error = new TreatmentErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<TreatmentErrorResponse> handleException(Exception exception) {
		TreatmentErrorResponse error = new TreatmentErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Bad Request");
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
