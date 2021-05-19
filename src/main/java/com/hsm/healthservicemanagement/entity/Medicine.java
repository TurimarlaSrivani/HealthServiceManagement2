package com.hsm.healthservicemanagement.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Medicine {
	@Id
	@NonNull
	private int medicineId;
	@NonNull
	private String medicineName;
	@NonNull
	private float medicineCost;
	@NonNull
	private LocalDate mfd;
	@NonNull
	private LocalDate expiryDate;
	@NonNull
	private int medicineQuantity;

}
