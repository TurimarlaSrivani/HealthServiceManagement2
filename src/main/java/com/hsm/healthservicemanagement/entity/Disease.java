
package com.hsm.healthservicemanagement.entity;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private int desId;
	@NonNull
	private String desName;
	@NonNull
	private String desType;
	@NonNull
	private String desSym;
	@NonNull
	private String desDur;
	
	//disease-patient
	@ManyToMany(targetEntity = Patient.class,cascade = CascadeType.ALL)
	@JoinTable(name ="disease_pat",
	joinColumns = {@JoinColumn(name ="desId")},
	inverseJoinColumns = {@JoinColumn(name="patientId")})
	
	private List<Patient> patientList = new ArrayList<>();
	
	@JsonManagedReference
	public List<Patient> getPatient() {
		return patientList;
	}

}