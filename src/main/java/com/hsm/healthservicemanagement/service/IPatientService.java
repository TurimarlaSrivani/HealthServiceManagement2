package com.hsm.healthservicemanagement.service;

import java.util.List;

import com.hsm.healthservicemanagement.entity.Patient;

public interface IPatientService {
	
	Patient save(Patient patient);
	String deleteBypatientid(int patientId);
	List<Patient> findAll();
	Patient update(Patient patient);
}
