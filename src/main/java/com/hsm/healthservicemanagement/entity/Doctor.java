package com.hsm.healthservicemanagement.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Doctor {
	
	@Id
	@NonNull
	private int doctorId;
	@NonNull
	private String doctorName;
	@NonNull
	private String contactNumber;
	@NonNull
	private int hoursOfAvailability;
	@NonNull
	private String specialization;
	@NonNull
	private String degree;
	@NonNull
	private int yearsOfExperience;
	@NonNull
	private double doctorFee;
	@NonNull
	private String userName;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_fk", referencedColumnName = "patientId")
	private Patient patient;
	
	
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

}
