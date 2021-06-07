package com.hsm.healthservicemanagement.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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
@Table(name = "policy")
public class Policy {

	@Id
	private int policyId;

	@NonNull
	@Size(min = 5, max = 35, message = "policyName should have atleast 5 characters")
	@Column(name = "policyName")
	private String policyName;

	@NonNull
	@Column(name = "createDate")
	private LocalDate createDate;

	@NonNull
	@Column(name = "endDate")
	private LocalDate endDate;

	@NonNull
	@Column(name = "maximumAmount")
	private Integer maximumAmount;

	// mapping between policy-patient(bidirectional)
	@JsonIgnore
	@OneToOne(mappedBy = "policy", cascade = CascadeType.ALL)
	private Patient patient;

}