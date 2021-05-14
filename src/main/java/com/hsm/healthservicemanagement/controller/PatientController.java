package com.hsm.healthservicemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.Patient;
import com.hsm.healthservicemanagement.service.IPatientService;

@RestController
public class PatientController {

	@Autowired
	IPatientService PatientService;
	
	@PostMapping("/patient")
	public Patient save(@RequestBody Patient patient) {
		return PatientService.save(patient);
	}
	
	@DeleteMapping("/patient/{id}")
	public String deleteBypatientid(@PathVariable("id") int patientId) {
		return PatientService.deleteBypatientid(patientId);
	}
	
	@GetMapping("/patient/allpatients")
	public List<Patient> getAllPatients() {
		return PatientService.findAll();
	}
	
	@PutMapping("/patients") 
	public Patient update(@RequestBody Patient patient) {
		return PatientService.update(patient);
	}
}
