package com.hsm.healthservicemanagement.service;

import java.util.List;

import com.hsm.healthservicemanagement.entity.Patient;

public interface IPatientService {
 	
	Patient findByPatientId(int id);
	List<Patient> findAll();
	Patient deleteByPatientId(int id);
	Patient save(Patient patient);
	Patient updateByPatientId(int id);
    Patient updatePatientName(int patientId, Patient patient);
	
	// custom methods
	// find by name
	Patient findByPatientName(String name);
	Patient delete(Patient patient);
}