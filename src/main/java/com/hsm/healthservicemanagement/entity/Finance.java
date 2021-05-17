package com.hsm.healthservicemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Finance {
	@Id
	private int financeId;
	private int patientId;
	private String patientName;
	private double registrationFee;
	private double doctorFee;
	private double medicinesAmount;
	private double totalFee;

	// @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	// @JoinColumn(name="patient", referencedColumnName = "patientId")
	// private Patient patient;

	// Constructors
	public Finance() {
	}

	public Finance(int patientId, String patientName, double registrationFee, double doctorFee, double medicinesAmount,
			double totalFee, int financeId) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.registrationFee = registrationFee;
		this.doctorFee = doctorFee;
		this.medicinesAmount = medicinesAmount;
		this.totalFee = totalFee;
		this.financeId = financeId;
	}

	// Getters & setters
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public double getRegistrationFee() {
		return registrationFee;
	}

	public void setRegistrationFee(double registrationFee) {
		this.registrationFee = registrationFee;
	}

	public double getDoctorFee() {
		return doctorFee;
	}

	public void setDoctorFee(double doctorFee) {
		this.doctorFee = doctorFee;
	}

	public double getMedicinesAmount() {
		return medicinesAmount;
	}

	public void setMedicinesAmount(double medicinesAmount) {
		this.medicinesAmount = medicinesAmount;
	}

	public double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	public int getFinanceId() {
		return financeId;
	}

	public void setFinanceId(int financeId) {
		this.financeId = financeId;
	}

	@Override
	public String toString() {
		return "Finance [patientId=" + patientId + ", patientName=" + patientName + ", registrationFee="
				+ registrationFee + ", doctorFee=" + doctorFee + ", medicinesAmount=" + medicinesAmount + ", totalFee="
				+ totalFee + ", financeId=" + financeId + "]";
	}

	/*
	 * public Patient getPatient() { return patient; }
	 * 
	 * public void setPatient(Patient patient) { this.patient = patient; }
	 * 
	 * @Override public String toString() { return "Finance [patientId=" + patientId
	 * + ", patientName=" + patientName + ", registrationFee=" + registrationFee +
	 * ", doctorFee=" + doctorFee + ", medicinesAmount=" + medicinesAmount +
	 * ", totalFee=" + totalFee + ", financeId=" + financeId + ", patient=" +
	 * patient + "]"; }
	 */

}