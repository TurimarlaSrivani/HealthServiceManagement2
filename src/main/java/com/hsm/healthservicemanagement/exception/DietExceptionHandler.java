package com.hsm.healthservicemanagement.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hsm.healthservicemanagement.entity.DietErrorResponse;




@ControllerAdvice
public class DietExceptionHandler {
   //Create method to handle exception
	@ExceptionHandler
   public ResponseEntity<DietErrorResponse> handleException(DietNotFoundException exception){
        DietErrorResponse error =new DietErrorResponse();
        
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
	
        return new ResponseEntity<>(error , HttpStatus.NOT_FOUND );
	}

	
	@ExceptionHandler
   public ResponseEntity<DietErrorResponse> handleException(Exception exception){
        DietErrorResponse error =new DietErrorResponse();
        
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Bad Request");
		error.setTimeStamp(System.currentTimeMillis());
	
        return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST );

	}

    }
	
	
	
	
	
	
	
	
	