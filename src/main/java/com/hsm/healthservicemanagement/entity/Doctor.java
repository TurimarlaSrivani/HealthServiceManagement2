package com.hsm.healthservicemanagement.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

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
@AllArgsConstructor
@RequiredArgsConstructor
public class Doctor {

	@Id
	@NonNull
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctorId;
	@NonNull
	@Size(min = 3, message = "Minimum charecters in  name should be 3.")
	private String doctorName;
	@NonNull
	private String contactNumber;
	@NonNull
	private int hoursOfAvailability;
	@NonNull
	@Size(min = 3, message = "Minimum charecters in  name should be 3.")
	private String specialization;
	@NonNull
	private String degree;
	@NonNull
	private int yearsOfExperience;
	@NonNull
	private double doctorFee;

	// doctor-patient(bidrectional)
	@ManyToMany(targetEntity = Patient.class, cascade = CascadeType.ALL)
	@JoinTable(name = "doctor_patient", joinColumns = { @JoinColumn(name = "doctorId") }, inverseJoinColumns = {
			@JoinColumn(name = "patientId") })

	private List<Patient> patientList = new ArrayList<>();

	@JsonManagedReference
	public List<Patient> getPatient() {
		return patientList;
	}
}
