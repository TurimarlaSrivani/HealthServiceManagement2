package com.hsm.healthservicemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@RequiredArgsConstructor
public class Treatment {
	@Id
	@NonNull
	private int treatmentId;
	@NonNull
	private String currentTreatment;
	@NonNull
	private double treatmentFee;
	@NonNull
	private LocalDate treatmentDate;
	@NonNull
	@Enumerated(EnumType.STRING)
	private TreatmentStatus treatmentStatus;

}
