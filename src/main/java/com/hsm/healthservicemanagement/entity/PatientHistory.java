package com.hsm.healthservicemanagement.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class PatientHistory {
	
	@Id
	private int patientHistoryId;
	//private int patientId;
	private LocalDate recordedDate;
	
	/*@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="dietId")
	private Diet diet;*/
	
	public PatientHistory() {}
	
	public PatientHistory(int patientHistoryId, LocalDate recordedDate)
	{
		this.patientHistoryId=patientHistoryId;
		this.recordedDate=recordedDate;
	}

	public int getPatientHistoryId() {
		return patientHistoryId;
	}

	public void setPatientHistoryId(int patientHistoryId) {
		this.patientHistoryId = patientHistoryId;
	}

	/*public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}*/

	public LocalDate getRecordedDate() {
		return recordedDate;
	}

	public void setRecordedDate(LocalDate recordedDate) {
		this.recordedDate = recordedDate;
	}

	@Override
	public String toString() {
		return "History [patientHistoryId=" + patientHistoryId + ", recordedDate="
				+ recordedDate + "]";
	}
	
	

}
