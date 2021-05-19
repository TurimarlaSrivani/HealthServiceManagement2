package com.hsm.healthservicemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@AllArgsConstructor
@RequiredArgsConstructor
public class PatientCase {

	@Id
	@NonNull
	private int patientCaseId;
	@NonNull
	private String medicines;
	@NonNull
	private String associateDoctorName;
	@NonNull
	private int medicineFee;
	@NonNull
	private String appointmentDate;
	@NonNull
	private String diseaseDescription;
	@NonNull
	private String currentTreatment;
	@NonNull
	private int patientId;

	// patcase-tre
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "treatment_fk", referencedColumnName = "treatmentId")
	private Treatment treatment;

	// patient-patientCase
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_fk", referencedColumnName = "patientId")
	private Patient patient;

}
