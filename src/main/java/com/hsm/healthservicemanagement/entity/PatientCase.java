package com.hsm.healthservicemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PatientCase {
	@Id
	private int patientCaseId;
	private String medicines;
	private String associateDoctorName;
	private int medicineFee;
	private String appointmentDate;
    private String diseaseDescription;
    private String currentTreatment;
    private int patientId;
    
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="patient", referencedColumnName = "patientId")
	private Patient patient;
    
    
    
   public PatientCase() {}
    public PatientCase(int patientCaseId,String medicines,String associateDoctorName,int medicineFee, String appointmentDate,String diseaseDescription,String currentTreatment,int patientId)
    {
    	this.patientCaseId =patientCaseId;
    	this.medicines = medicines;
    	this.associateDoctorName =associateDoctorName;
    	this.medicineFee =medicineFee;
    	this.appointmentDate=appointmentDate;
    	this.diseaseDescription =diseaseDescription;
    	this.currentTreatment =currentTreatment;
    	this.patientId =patientId;
    }
	
	public int getPatientCaseId() {
		return patientCaseId;
	}
	public void setPatientCaseId(int patientCaseId) {
		this.patientCaseId = patientCaseId;
	}
	public String getMedicines() {
		return medicines;
	}
	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}
	public String getAssociateDoctorName() {
		return associateDoctorName;
	}
	public void setAssociateDoctorName(String associateDoctorName) {
		this.associateDoctorName = associateDoctorName;
	}
	public int getMedicineFee() {
		return medicineFee;
	}
	public void setMedicineFee(int medicineFee) {
		this.medicineFee = medicineFee;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getDiseaseDescription() {
		return diseaseDescription;
	}
	public void setDiseaseDescription(String diseaseDescription) {
		this.diseaseDescription = diseaseDescription;
	}
	public String getCurrentTreatment() {
		return currentTreatment;
	}
	public void setCurrentTreatment(String currentTreatment) {
		this.currentTreatment = currentTreatment;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "PatientCase [patientCaseId=" + patientCaseId + ", medicines=" + medicines + ", associateDoctorName="
				+ associateDoctorName + ", medicineFee=" + medicineFee + ", appointmentDate=" + appointmentDate
				+ ", diseaseDescription=" + diseaseDescription + ", currentTreatment=" + currentTreatment
				+ ", patientId=" + patientId + "]";
	}

	
	
}




