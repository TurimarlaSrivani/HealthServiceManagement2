package com.hsm.healthservicemanagement.controller;

/*
 * 1.Create error message for pojo class
 * 2.create custom exception class
 * 3.throw the exception from the controller
 * 4.@ExceptionHandler - handle exceptions
 * 
 */
public class TreatmentErrorResponse {
	private int status; // error code 404
	private String message; // treatment not found with the given id
	private long timeStamp;

	// Constructors
	public TreatmentErrorResponse() {
	}

	public TreatmentErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	// getters and setters
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	// ToString
	@Override
	public String toString() {
		return "TreatmentErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}

}