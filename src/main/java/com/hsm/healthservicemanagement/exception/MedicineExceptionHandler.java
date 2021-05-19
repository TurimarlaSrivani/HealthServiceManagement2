package com.hsm.healthservicemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hsm.healthservicemanagement.entity.HmsErrorResponse;


@ControllerAdvice
public class MedicineExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<HmsErrorResponse> handleException(MedicineNotFoundException exception) {
		HmsErrorResponse error = new HmsErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());// 404
		error.setMessage("Not Found");
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<HmsErrorResponse> handleException(Exception exception) {
		HmsErrorResponse error = new HmsErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());// 400
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}