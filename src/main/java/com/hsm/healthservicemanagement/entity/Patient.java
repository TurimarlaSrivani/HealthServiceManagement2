package com.hsm.healthservicemanagement.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;


@Entity
public class Patient{ 
	
    @Id
	private int patientId;
	private String patientName;
	private int patientAge;
	private int registrationFee;
	private String patientContactNumber;
	private String symptoms;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address")
	private Address address;
	
	//Constructors
	public Patient() {}
	
	public Patient(int patientId,String patientName,int patientAge,int registrationFee,String patientContactNumber,String symptoms,
	LocalDate createdAt, LocalDate updatedAt) 
	{
	this.patientId = patientId;
	this.patientName = patientName;
	this.patientAge = patientAge;
	this.registrationFee = registrationFee;
	this.patientContactNumber = patientContactNumber;
	this.symptoms = symptoms;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
    }   
	
	//Getters and Setters
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

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public int getRegistrationFee() {
		return registrationFee;
	}

	public void setRegistrationFee(int registrationFee) {
		this.registrationFee = registrationFee;
	}


	public String getPatientContactNumber() {
		return patientContactNumber;
	}

	public void setPatientContactNumber(String patientContactNumber) {
		this.patientContactNumber = patientContactNumber;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", registrationFee=" + registrationFee + ", patientContactNumber=" + patientContactNumber
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", address=" + address + ", symptoms="
				+ symptoms + "]";
	}



}