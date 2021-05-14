package com.hsm.healthservicemanagement.exception;

public class PolicyNotFoundException extends RuntimeException {
	public PolicyNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PolicyNotFoundException(String message) {
		super(message);
	}

	public PolicyNotFoundException(Throwable cause) {
		super(cause);
	}

}
