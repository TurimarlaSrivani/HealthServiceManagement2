package com.hsm.healthservicemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Patient;
import com.hsm.healthservicemanagement.repository.IPatientRepository;

@Service
public class PatientServiceImpl implements IPatientService{
	
    @Autowired
	IPatientRepository patientRepo;
	
    @Override
	public Patient save(Patient patient) {
		return patientRepo.save(patient);
	}
    
    @Override
	public String deleteBypatientid(int id) {
		patientRepo.deleteById(id);
		return "patient with id " +id+ " is deleted";
	}
    
    @Override
	public List<Patient> findAll() {
		return  patientRepo.findAll();
	}

	@Override
	public Patient update(Patient patient) {
		Patient pat = patientRepo.findById(patient.getPatientId()).get();
		pat.setPatientName(patient.getPatientName());
		return patientRepo.save(pat);
	}
}
