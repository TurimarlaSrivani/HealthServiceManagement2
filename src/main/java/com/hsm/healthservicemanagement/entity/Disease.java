package com.hsm.healthservicemanagement.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Disease{
	
	@Id
	private int desId;
	private String desName;
	private String desType;
	private String desSym;
	private String desDur;
	

	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address")
	private Address address;*/
	
	
	
	// Constructors
	public Disease() {
	}
	
	public Disease(int desId,String desName,String desType,String desSym,String desDur) {
		this.desId = desId;
		this.desName = desName;
		this.desType = desType;
		this.desSym= desSym;
		this.desDur = desDur;
		
	}

	public int getDesId() {
		return desId;
	}

	public void setDesId(int desId) {
		this.desId = desId;
	}

	public String getDesName() {
		return desName;
	}

	public void setDesName(String desName) {
		this.desName = desName;
	}

	public String getDesType() {
		return desType;
	}

	public void setDesType(String desType) {
		this.desType = desType;
	}

	public String getDesSym() {
		return desSym;
	}

	public void setDesSym(String desSym) {
		this.desSym = desSym;
	}

	public String getDesDur() {
		return desDur;
	}

	public void setDesDur(String desDur) {
		this.desDur = desDur;
	}

	@Override
	public String toString() {
		return "PatientDisease [desId=" + desId + ", desName=" + desName + ", desType=" + desType + ", desSym=" + desSym
				+ ", desDur=" + desDur + "]";
	}

	
/*	public Employee(int empId, String empName, String dept) {
		this.empId = empId;
		this.empName = empName;
		this.dept = dept;
	}*/
	// Getters & setters
	
	
}
