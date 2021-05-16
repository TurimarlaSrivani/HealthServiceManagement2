package com.cg.hsm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Treatment {

	@Id
	private int treatmentId;
	private int patientCaseId;
	private String currentTreatment;
	private double treatmentFee;
	private LocalDate treatmentDate;
	private TreatmentStatus treatmentStatus;

	// Constructors
	public Treatment() {
	}

	public Treatment(int treatmentId, int patientCaseId, LocalDate treatmentDate, int treatmentFee,
			String currentTreatment, TreatmentStatus treatmentStatus) {
		super();
		this.treatmentId = treatmentId;
		this.patientCaseId = patientCaseId;
		this.treatmentDate = treatmentDate;
		this.treatmentFee = treatmentFee;
		this.currentTreatment = currentTreatment;
		this.treatmentStatus = treatmentStatus;
	}

	public Treatment(int treatmentId, int patientCaseId, LocalDate treatmentDate, int treatmentFee,
			String currentTreatment) {
		super();
		this.treatmentId = treatmentId;
		this.patientCaseId = patientCaseId;
		this.treatmentDate = treatmentDate;
		this.treatmentFee = treatmentFee;
		this.currentTreatment = currentTreatment;
	}

	public TreatmentStatus getTreatmentStatus() {
		return treatmentStatus;
	}

	public void setTreatmentStatus(TreatmentStatus treatmentStatus) {
		this.treatmentStatus = treatmentStatus;
	}

	public int getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(int treatmentId) {
		this.treatmentId = treatmentId;
	}

	public int getPatientCaseId() {
		return patientCaseId;
	}

	public void setPatientCaseId(int patientId) {
		this.patientCaseId = patientId;
	}

	public String getCurrentTreatment() {
		return currentTreatment;
	}

	public void setCurrentTreatment(String treatmentName) {
		this.currentTreatment = treatmentName;
	}

	public double getTreatmentFee() {
		return treatmentFee;
	}

	public void setTreatmentFee(double treatmentFee) {
		this.treatmentFee = treatmentFee;
	}

	public LocalDate getTreatmentDate() {
		return treatmentDate;
	}

	public void setTreatmentDate(LocalDate treatmentDate) {
		this.treatmentDate = treatmentDate;
	}

	@Override
	public String toString() {
		return "Treatment [treatmentId=" + treatmentId + ", patientCaseId=" + patientCaseId + ", currentTreatment="
				+ currentTreatment + ", treatmentFee=" + treatmentFee + ", treatmentDate=" + treatmentDate + ", treatmentStatus="
				+ treatmentStatus + "]";
	}
}
