package com.hsm.healthservicemanagement.exception;

@SuppressWarnings("serial")
public class DiseaseNotFoundException extends RuntimeException {

		public DiseaseNotFoundException(String message, Throwable cause) {
			super(message, cause);
		}

		public DiseaseNotFoundException(String message) {
			super(message);
		}

		public DiseaseNotFoundException(Throwable cause) {
			super(cause);
		}
		
	}
