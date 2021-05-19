
package com.hsm.healthservicemanagement.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Policy {

	
	@Id
	@NonNull
	private int policyId;
	@NonNull
	private String policyName;
	@NonNull
	private LocalDate createDate;
	@NonNull
	private LocalDate endDate;
	@NonNull
	private Integer maximumAmount;
	
	//policy-patient(bidirectional)
	@JsonIgnore
	@OneToOne(mappedBy="policy", cascade = CascadeType.ALL)
	private Patient patient;

}
