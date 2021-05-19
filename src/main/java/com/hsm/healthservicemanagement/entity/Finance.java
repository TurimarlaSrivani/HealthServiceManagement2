package com.hsm.healthservicemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
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
public class Finance {

	@Id
	@NonNull
	private int financeId;
	@NonNull
	private int patientId;
	@NonNull
	private String patientName;
	@NonNull
	private double registrationFee;
	@NonNull
	private double doctorFee;
	@NonNull
	private double medicinesAmount;
	@NonNull
	private double totalFee;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_fk", referencedColumnName = "patientId")
	private Patient patient;

}