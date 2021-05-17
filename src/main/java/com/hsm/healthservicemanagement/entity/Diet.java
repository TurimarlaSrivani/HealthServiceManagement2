package com.hsm.healthservicemanagement.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.Id;

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
public class Diet
{
	@Id
	@NonNull
	private int dietId;
	@NonNull
	private String dietType;
	@NonNull
	private String foodtoEat;
	@NonNull
	private int dietDuration;

}