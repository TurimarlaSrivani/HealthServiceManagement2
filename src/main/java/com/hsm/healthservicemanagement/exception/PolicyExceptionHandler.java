package com.hsm.healthservicemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.hsm.healthservicemanagement.*;
import com.hsm.healthservicemanagement.entity.*;
import com.hsm.healthservicemanagement.*;

@ControllerAdvice
public class PolicyExceptionHandler {

	@ExceptionHandler
	   public ResponseEntity<PolicyErrorResponse> handleException(PolicyNotFoundException exception){
	        PolicyErrorResponse error =new PolicyErrorResponse();
	        
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exception.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
		
	        return new ResponseEntity<>(error , HttpStatus.NOT_FOUND );
		}

	
	@ExceptionHandler
	   public ResponseEntity<PolicyErrorResponse> handleException(Exception exception){
	        PolicyErrorResponse error =new PolicyErrorResponse();
	        
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage("Bad Request");
			error.setTimeStamp(System.currentTimeMillis());
		
	        return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST );

		}

}
