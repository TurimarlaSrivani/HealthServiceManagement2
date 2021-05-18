package com.hsm.healthservicemanagement.service;

import java.util.List;

import com.hsm.healthservicemanagement.entity.PatientHistory;

public interface IPatientHistoryService {
	
	PatientHistory addPatientHistory(PatientHistory his);
	PatientHistory findByPatientHistoryId(int patientHistoryId);
	String deleteByPatientHistoryId(int patientHistoryId);
	PatientHistory updatePatientHistory(PatientHistory his);
	List<PatientHistory> getAllPatientHistory();
	//PatientHistory findByPatientId(int patientId);

}
