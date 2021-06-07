package com.hsm.healthservicemanagement.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.hsm.healthservicemanagement.entity.Patient;

@Service
//Service layer method
public interface IPatientService {

	// Method to be override by the implementing class
	// findPatientByPatientId
	Patient findByPatientId(int id);

	// Method to be override by the implementing class
	// ListAllPatient
	List<Patient> findAll();

	// Method to be override by the implementing class
	// deletePatientByPatientId
	Patient deleteByPatientId(int id);

	// Method to be override by the implementing class
	// save patient
	Patient save(Patient patient);


	// Method to be override by the implementing class
	// updatePatient
	Patient updatePatient( Patient patient);

	// custom methods

	// Method to be override by the implementing class
	// findPatient by PatientName
	Patient findByPatientName(String name);

	// Method to be override by the implementing class
	// deletePatient
	Patient delete(Patient patient);
}