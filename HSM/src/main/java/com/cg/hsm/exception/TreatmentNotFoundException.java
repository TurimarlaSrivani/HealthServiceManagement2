package com.cg.hsm.exception;

/*
 * 1.Create error message for pojo class
 * 2.create custom exception class
 * 3.throw the exception from the controller
 * 4.@ExceptionHandler - handle exceptions
 * 
 */
public class TreatmentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
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