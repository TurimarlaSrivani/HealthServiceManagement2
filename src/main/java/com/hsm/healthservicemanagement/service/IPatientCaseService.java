package com.hsm.healthservicemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.PatientCase;

@Service
public interface IPatientCaseService // Service layer method
{
	// Method to be override by the implementing class
	// save patientCase
	public PatientCase save(PatientCase PatientCase);

	// Method to be override by the implementing class
	// deletePatientCaseByPatientcaseId
	public PatientCase deletePatientCase(int id);

	// Method to be override by the implementing class
	// viewAllPatientcaseDetails
	public List<PatientCase> viewAll();

	// Method to be override by the implementing class
	// viewPatientCaseByPatientCaseId
	public PatientCase viewPatientCaseById(int Id);

	// Method to be override by the implementing class
	// update
	public PatientCase update(PatientCase PatientCase);
}