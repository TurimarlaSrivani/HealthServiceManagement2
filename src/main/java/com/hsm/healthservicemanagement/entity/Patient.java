package com.hsm.healthservicemanagement.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Patient {
	
    @Id
    private int patientId;
    private String patientName;
    
    @OneToOne(mappedBy="patient", cascade = CascadeType.ALL)
    private Doctor doctor;
    
    @JsonBackReference
    public Doctor getDoctor() {
    	return doctor;
    }
    
/*    @ManyToMany(mappedBy = "patients", cascade = CascadeType.ALL)
	private List<Doctor> doctors = new ArrayList<>();
    
    @JsonBackReference
    public List<Doctor> getdoctors() {
    	return doctors;
    }*/
    
    public Patient() {}

	public Patient(int patientId, String patientName) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
	}

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

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + "]";
	}

	
}
