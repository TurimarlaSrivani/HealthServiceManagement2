package com.hsm.healthservicemanagement.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
public class PatientHistory {

	@Id
	@NonNull
	private int patientHistoryId;
	
	@NonNull
	@Column(name="recordedDate")
	private LocalDate recordedDate;

	// patientHistory-diet(unidirectional)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "diet_fk", referencedColumnName = "dietId")
	private Diet diet;

	// patientHistory-disease(unidirectional)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "disease_fk", referencedColumnName = "diseaseId")
	private Disease disease;

	// patientHistory-patient
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id", referencedColumnName = "patientId")
	private Patient patient;

}