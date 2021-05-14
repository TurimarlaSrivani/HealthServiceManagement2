package com.hsm.healthservicemanagement.exception;

public class DoctorNotFoundException extends RuntimeException {
	
	public DoctorNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DoctorNotFoundException(String message) {
		super(message);
	}
	
	public DoctorNotFoundException(Throwable cause) {
		super(cause);
	}

}
