package com.hsm.healthservicemanagement.exception;

public class FinanceNotFoundException extends RuntimeException {

	public FinanceNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public FinanceNotFoundException(String message) {
		super(message);

	}

	public FinanceNotFoundException(Throwable cause) {
		super(cause);

	}

}