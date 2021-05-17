package com.hsm.healthservicemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Doctor {
	
	@Id
	private int doctorId;
	private String doctorName;
	private String contactNumber;
	private int hoursOfAvailability;
	private String specialization;
	private String degree;
	private int yearsOfExperience;
	private double doctorFee;
	private String userName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Doctors_patient", referencedColumnName = "patientId")
	private Patient patient;
	
	
	@JsonManagedReference
	public Patient getPatient() {
		return patient;
	}
	
/*	@ManyToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
    @JoinTable(name = "doctors_patient",
    joinColumns = {@JoinColumn(name = "doctorId")},
    inverseJoinColumns = {@JoinColumn(name = "patientId")}
    )
    private List<Patient> patients = new ArrayList<>();
	
	@JsonManagedReference
	public List<Patient> getpatients() {
		return patients;
	}*/
	
	
	// Constructors
		public Doctor() {
		}
		
	public Doctor(int doctorId, String doctorName, String contactNumber, int hoursOfAvailability, String specialization,
			String degree, int yearsOfExperience, double doctorFee, String userName) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.contactNumber = contactNumber;
		this.hoursOfAvailability = hoursOfAvailability;
		this.specialization = specialization;
		this.degree = degree;
		this.yearsOfExperience = yearsOfExperience;
		this.doctorFee = doctorFee;
		this.userName = userName;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getHoursOfAvailability() {
		return hoursOfAvailability;
	}

	public void setHoursOfAvailability(int hoursOfAvailability) {
		this.hoursOfAvailability = hoursOfAvailability;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public double getDoctorFee() {
		return doctorFee;
	}

	public void setDoctorFee(double doctorFee) {
		this.doctorFee = doctorFee;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", contactNumber=" + contactNumber
				+ ", hoursOfAvailability=" + hoursOfAvailability + ", specialization=" + specialization + ", degree="
				+ degree + ", yearsOfExperience=" + yearsOfExperience + ", doctorFee=" + doctorFee + ", userName="
				+ userName + "]";
	}

}
