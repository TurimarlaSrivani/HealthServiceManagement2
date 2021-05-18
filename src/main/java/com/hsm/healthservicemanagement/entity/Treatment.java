package com.hsm.healthservicemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Treatment {
	@Id
	private int treatmentId;
	private String currentTreatment;
	private double treatmentFee;
	private LocalDate treatmentDate;
	@Enumerated(EnumType.STRING)
	private TreatmentStatus treatmentStatus;

}
