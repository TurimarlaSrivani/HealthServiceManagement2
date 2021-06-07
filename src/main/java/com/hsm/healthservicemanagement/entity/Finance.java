package com.hsm.healthservicemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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
@AllArgsConstructor
@Table(name = "finance")

public class Finance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "finance_id", nullable = false)
	private int financeId;

	@Size(min = 3, message = "Minimum charecters in  name should be 3.")
	private String patientName;

	private double registrationFee;

	private double doctorFee;

	private double medicinesAmount;

	private double totalFee;

}