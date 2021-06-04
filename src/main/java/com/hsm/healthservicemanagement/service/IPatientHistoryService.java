package com.hsm.healthservicemanagement.service;

import java.util.List;

import com.hsm.healthservicemanagement.entity.PatientHistory;

public interface IPatientHistoryService  // Service layer method
{
	
	// Method to be override by the implementing class
	// addPatientHistory
	PatientHistory addPatientHistory(PatientHistory history);
	
	// Method to be override by the implementing class
	//findByPatientHistoryId
	PatientHistory findByPatientHistoryId(int patientHistoryId);
	
	// Method to be override by the implementing class
	//deleteByPatientHistoryId
	String deleteByPatientHistoryId(int patientHistoryId);
	
	// Method to be override by the implementing class
	//updatePatientHistory
	PatientHistory updatePatientHistory(PatientHistory history);
	
	// Method to be override by the implementing class
	//getAllPatientHistory
	List<PatientHistory> getAllPatientHistory();
	
	//PatientHistory findByPatientId(int patientId);

}