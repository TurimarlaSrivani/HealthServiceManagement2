package com.hsm.healthservicemanagement.exception;

   
public class DietNotFoundException extends RuntimeException {

	public DietNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public DietNotFoundException(String message) {
		super(message);

	}

	public DietNotFoundException(Throwable cause) {
		super(cause);

	}

}
