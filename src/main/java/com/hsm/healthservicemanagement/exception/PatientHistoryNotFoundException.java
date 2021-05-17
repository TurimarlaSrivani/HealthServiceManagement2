package com.hsm.healthservicemanagement.exception;

public class PatientHistoryNotFoundException extends RuntimeException {

	public PatientHistoryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PatientHistoryNotFoundException(String message) {
		super(message);
		
	}

	public PatientHistoryNotFoundException(Throwable cause) {
		super(cause);
		
	}
	
	

}
