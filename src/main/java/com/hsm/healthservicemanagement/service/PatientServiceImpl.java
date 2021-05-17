package com.hsm.healthservicemanagement.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hsm.healthservicemanagement.entity.Patient;
import com.hsm.healthservicemanagement.repository.IPatientRepository;

@Service
public  class PatientServiceImpl implements IPatientService {


	@Autowired
	IPatientRepository patientRepo;

	@Override
	public Patient findByPatientId(int id) {
		
		Optional<Patient> patient = patientRepo.findById(id);
		if(!patient.isPresent()) {
			return null;
		}
		return patient.get();
	}

	
	@Override
	public List<Patient> findAll() {
		return patientRepo.findAll();
	}
	
	@Override
	public Patient save(Patient patient) {
		return patientRepo.save(patient);
	}
	
	
	@Override
	public Patient findByPatientName(String name) {
		return  patientRepo.findByPatientName(name);
	}


	@Override
	public Patient deleteByPatientId(int id) {
	  Optional<Patient> patient = patientRepo.findById(id);
	if(!patient.isPresent()) {
		return null;
	}
	patientRepo.deleteById(id);
	return patient.get();
}


	@Override
	public Patient delete(Patient patient) {
		patientRepo.delete(patient);
		return patient;
	}


	@Override
	public Patient updateByPatientId(int id) {
	  Optional<Patient> patient = patientRepo.findById(id);
		if(!patient.isPresent()) {
			return null;
		}
		return patient.get();
	}
	
	@Override
	public Patient updatePatientName(int patientId, Patient patient) {
		Optional<Patient> pat = patientRepo.findById(patientId);
		if(!pat.isPresent()) {
			return null;
		}
		pat.get().setPatientName(patient.getPatientName());
		return patientRepo.save(pat.get());
	}
	
}