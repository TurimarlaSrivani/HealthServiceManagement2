package com.hsm.healthservicemanagement.exception;

public class PatientCaseNotFoundException extends RuntimeException {

	public PatientCaseNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PatientCaseNotFoundException(String message) {
		super(message);
		
	}

	public PatientCaseNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
