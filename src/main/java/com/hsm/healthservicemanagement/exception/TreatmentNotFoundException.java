package com.hsm.healthservicemanagement.exception;

public class TreatmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TreatmentNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public TreatmentNotFoundException(String message) {
		super(message);

	}

	public TreatmentNotFoundException(Throwable cause) {
		super(cause);

	}

}
