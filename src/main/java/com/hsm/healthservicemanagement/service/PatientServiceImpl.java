package com.hsm.healthservicemanagement.service;

import java.util.List;

import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hsm.healthservicemanagement.entity.Patient;
import com.hsm.healthservicemanagement.repository.IPatientRepository;

@Service
//Implementation of service layer method by implements method
public class PatientServiceImpl implements IPatientService {

	@Autowired
	IPatientRepository patientRepo;
	// Used to store the given patient Object passes from the controller
	// Logger declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PatientServiceImpl.class);

	// Get a specific patient of the given ID
	// findPatientById
	@Override
	public Patient findByPatientId(int id) {
		// setting logger info
		logger.info("Find the patient details By Id");
		Optional<Patient> patient = patientRepo.findById(id);
		if (!patient.isPresent()) {
			return null;
		}
		return patient.get();
	}

	// Used to list all the patient from the database
	// findAllPatientDetails
	@Override
	public List<Patient> findAll() {
		// setting logger info
		logger.info("Find the details of the patient");
		return patientRepo.findAll();
	}

	// Used to store the given patient object that passes from the controller
	// save patient
	@Override
	public Patient save(Patient patient) {
		// setting logger info
		logger.info("save the details of the patient");
		return patientRepo.save(patient);
	}

	@Override
	// Get a specific patient of the given name
	// findPatientByName
	public Patient findByPatientName(String name) {
		// setting logger info
		logger.info("Find the patient details By Name");
		return patientRepo.findByPatientName(name);
	}

	// Used to delete the patient by id
	// deleteByPatientId
	@Override
	public Patient deleteByPatientId(int id) {
		// setting logger info
		logger.info("delete the patient details by id");
		Optional<Patient> patient = patientRepo.findById(id);
		if (!patient.isPresent()) {
			return null;
		}
		patientRepo.deleteById(id);
		return patient.get();
	}

	// Used to delete the patient
	// deletePatient
	@Override
	public Patient delete(Patient patient) {
		// setting logger info
		logger.info("delete the patient details ");
		patientRepo.delete(patient);
		return patient;
	}

	// Used to update the patient.
	// updateByPatient
	@Override
	public Patient updatePatient(Patient patient) {
		// setting logger info
		logger.info("update the patient details ");

		Patient p = patientRepo.findById(patient.getPatientId()).get();
		p.setPatientName(patient.getPatientName());
		p.setPatientAge(patient.getPatientAge());
		p.setRegistrationFee(patient.getRegistrationFee());
		p.setPatientContactNumber(patient.getPatientContactNumber());
		p.setSymptoms(patient.getSymptoms());
		p.setCreatedAt(patient.getCreatedAt());
		p.setUpdatedAt(patient.getUpdatedAt());
		return patientRepo.save(p);
	}

}