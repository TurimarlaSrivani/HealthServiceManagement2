package com.hsm.healthservicemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ToString
@NoArgsConstructor

public class Diet
{
	
	@Id
	private int dietId;
	private String dietType;
	private String foodtoEat;

	private String dietDuration;
	private int dietDuration;

}