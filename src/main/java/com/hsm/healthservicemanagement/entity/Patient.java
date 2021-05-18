package com.hsm.healthservicemanagement.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Patient {

	@Id
	@NonNull
	private int patientId;
	@NonNull
	private String patientName;
	@NonNull
	private int patientAge;
	@NonNull
	private int registrationFee;
	@NonNull
	private String patientContactNumber;
	@NonNull
	private String symptoms;
	@NonNull
	private LocalDate createdAt;
	@NonNull
	private LocalDate updatedAt;

	// patient-address(unidirectional)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address")
	private Address address;

	// patient-doctor(bidirectional)
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "patientList")
	private List<Doctor> doctorList;

	@JsonBackReference
	public List<Doctor> getDoctor() {
		return doctorList;
	}

	// patient-disease
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "patientList")
	private List<Disease> diseaseList;

	@JsonBackReference
	public List<Disease> getDisease() {
		return diseaseList;
	}

	// patient-patientCase
	@JsonIgnore
	@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
	private PatientCase patientcase;

	// patient-policy(bidirectional)
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "policy_fk", referencedColumnName = "policyId")
	private Policy policy;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
	private Set<PatientHistory> patienthistory = new HashSet<>();
}