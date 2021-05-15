package com.hsm.healthservicemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient1 {
	@Id
	private int patientId;

	public Patient1(int patientId) {
		super();
		this.patientId = patientId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + "]";
	}
	
	
}
