package com.hsm.healthservicemanagement.entity;

public class FinanceErrorResponse {
	private int status; // error code 404
	private String message; // finance not found with the given id
	private long timeStamp;

	// Constructors
	public FinanceErrorResponse() {
	}

	public FinanceErrorResponse(int status, String message, long timeStamp) {
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
		return "FinanceErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}

}
