package com.hsm.healthservicemanagement.exception;

public class PatientNotFoundException extends RuntimeException{

	public PatientNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PatientNotFoundException(String message) {
		super(message);
	}

	public PatientNotFoundException(Throwable cause) {
		super(cause);
	}
	
}

