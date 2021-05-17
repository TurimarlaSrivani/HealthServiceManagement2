package com.hsm.healthservicemanagement.entity;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
public class Disease{

	
	@Id
	@NonNull
	private int desId;
	@NonNull
	private String desName;
	@NonNull
	private String desType;
	@NonNull
	private String desSym;
	@NonNull
	private String desDur;
	
/*	@OneToMany(targetEntity = Doctor.class,cascade = CascadeType.ALL)
	@JoinColumn(name= "doctor_fk",referencedColumnName = "doctorName")
	private List<Doctor> doctors; */

}
