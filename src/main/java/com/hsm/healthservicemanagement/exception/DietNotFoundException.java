package com.hsm.healthservicemanagement.exception;

/*

 * 1.Create error message for pojo class
 * 2.Create custom exception class
 * 3.throw the exception from the controller
 * 4.@ExceptionHandler - handle exceptions

 */
   
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
