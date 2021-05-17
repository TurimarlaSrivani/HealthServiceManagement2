package com.hsm.healthservicemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import java.time.LocalDate;

@Entity
public class Treatment {

	@Id
	private int treatmentId;
	private String currentTreatment;
	private double treatmentFee;
	private LocalDate treatmentDate;
	private TreatmentStatus treatmentStatus;

	//@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	//@JoinColumn(name="patientCase", referencedColumnName="patientCaseId")
	//private PatientCase patientCase;
	
	
	// Constructors
	public Treatment() {
	}

	public Treatment(int treatmentId,LocalDate treatmentDate, int treatmentFee,
			String currentTreatment, TreatmentStatus treatmentStatus) {
		super();
		this.treatmentId = treatmentId;
		this.treatmentDate = treatmentDate;
		this.treatmentFee = treatmentFee;
		this.currentTreatment = currentTreatment;
		this.treatmentStatus = treatmentStatus;
	}

	public Treatment(int treatmentId, LocalDate treatmentDate, int treatmentFee,
			String currentTreatment) {
		super();
		this.treatmentId = treatmentId;
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
		return "Treatment [treatmentId=" + treatmentId + ", currentTreatment="
				+ currentTreatment + ", treatmentFee=" + treatmentFee + ", treatmentDate=" + treatmentDate + ", treatmentStatus="
				+ treatmentStatus + "]";
	}
}
