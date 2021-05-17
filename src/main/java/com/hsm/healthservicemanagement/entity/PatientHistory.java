package com.hsm.healthservicemanagement.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
public class PatientHistory {

	
	@Id
	@NonNull
	private int patientHistoryId;
	@NonNull
	private int patientId;
	@NonNull
	private LocalDate recordedDate;
	private String diseaseName;
	private String dietAdvice;
	
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="diet_fk", referencedColumnName="dietId")
	private Diet diet;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="patient_fk", referencedColumnName="patientId")
	private Patient patient;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="disease_fk", referencedColumnName="desId")
	private Disease disease;

}
