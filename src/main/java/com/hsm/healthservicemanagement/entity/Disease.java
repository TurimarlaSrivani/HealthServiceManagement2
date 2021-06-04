package com.hsm.healthservicemanagement.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Disease{

	
	@Id
	@NonNull
	private int diseaseId;
	
	@NonNull
	@Size(min = 3, message = "Minimum charecters in  name should be 3.")
	@Column(name = "diseaseName")
	private String diseaseName;
	
	@NonNull
	private String diseaseType;
	
	@NonNull
	private String diseaseSymptoms;

	
	//disease-patient
	@ManyToMany(targetEntity = Patient.class,cascade = CascadeType.ALL)
	@JoinTable(name ="disease_patient",
	joinColumns = {@JoinColumn(name ="diseaseId")},
	inverseJoinColumns = {@JoinColumn(name="patientId")})
	
	private List<Patient> patientList = new ArrayList<>();
	
	@JsonManagedReference
	public List<Patient> getPatient() {
		return patientList;
	}

}