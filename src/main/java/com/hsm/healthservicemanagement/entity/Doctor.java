package com.hsm.healthservicemanagement.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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


	// doctor-patient(bidrectional)
	@ManyToMany(targetEntity = Patient.class, cascade = CascadeType.ALL)
	@JoinTable(name = "doct_pat", joinColumns = { @JoinColumn(name = "doctorId") }, inverseJoinColumns = {
			@JoinColumn(name = "patientId") })

	private List<Patient> patientList = new ArrayList<>();

	@JsonManagedReference
	public List<Patient> getPatient() {
		return patientList;
	}
}
