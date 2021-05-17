package com.hsm.healthservicemanagement.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
@RequiredArgsConstructor
@AllArgsConstructor
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
	
	// doctor-patient
		@JsonIgnore
		@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
		private Doctor doctor;

		// patient-patientCase
		@JsonIgnore
		@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
		private PatientCase patientcase;

		// patient-address
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "address")
		private Address address;

		// patient-policy
		@JsonIgnore
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "policy_fk", referencedColumnName = "policyId")
		private Policy policy;

		// patient-patienthistory
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "patientid_fk", referencedColumnName = "patientId")
		private List<PatientHistory> patienthistory = new ArrayList<>();

		
}