package com.hsm.healthservicemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.hsm.healthservicemanagement.entity.DiseaseErrorResponse;

@ControllerAdvice
public class DiseaseExceptionHandler {

		@ExceptionHandler
		public ResponseEntity<DiseaseErrorResponse> handleException(DiseaseNotFoundException exception) {
			DiseaseErrorResponse error = new DiseaseErrorResponse();
			
			error.setStatus(HttpStatus.NOT_FOUND.value()); // 404
			error.setMessage(exception.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		@ExceptionHandler
		public ResponseEntity<DiseaseErrorResponse> handleException(Exception exception) {
			DiseaseErrorResponse error = new DiseaseErrorResponse();
			
			error.setStatus(HttpStatus.BAD_REQUEST.value()); // 400
			error.setMessage(exception.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

