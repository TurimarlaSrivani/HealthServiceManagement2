package com.hsm.healthservicemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.Patient;
import com.hsm.healthservicemanagement.entity.HmsErrorResponse;
import com.hsm.healthservicemanagement.exception.PatientNotFoundException;
import com.hsm.healthservicemanagement.service.IPatientService;

@RestController
public class PatientController {

	@Autowired
	IPatientService patientService;

	@ExceptionHandler
	public ResponseEntity<HmsErrorResponse> handleException(PatientNotFoundException exception) {
		HmsErrorResponse error = new HmsErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/patient/id/{id}")
	public Patient findByPatientId(@PathVariable("id") int patientId) {
		if (patientService.findByPatientId(patientId) == null) {
			throw new PatientNotFoundException("Patient not found with given id: " + patientId);
		}
		return patientService.findByPatientId(patientId);
	}

	@PostMapping("/patient")
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.save(patient);
	}

	@GetMapping("/patient")
	public List<Patient> findAll() {
		return patientService.findAll();
	}

	// DELETE
	@DeleteMapping("/patient/{id}")
	public Patient deleteByPatientId(@PathVariable("id") int patientId) {
		if (patientService.deleteByPatientId(patientId) == null) {
			throw new PatientNotFoundException("Patient not found with given id: " + patientId);
		}
		return patientService.deleteByPatientId(patientId);

	}

	// find by name
	@GetMapping("/patient/{name}")
	public Patient findByPatientName(@PathVariable("name") String name) {
		if (patientService.findByPatientName(name) == null) {
			throw new PatientNotFoundException("Patient not found with given name: " + name);
		}
		return patientService.findByPatientName(name);
	}

	@PutMapping("/patient/{id}")
	public Patient updateByPatientId(@PathVariable("id") int patientId) {
		if (patientService.updateByPatientId(patientId) == null) {
			throw new PatientNotFoundException("Patient not found with given id: " + patientId);
		}
		return patientService.updateByPatientId(patientId);

	}

	// UPDATE
	// Updating specific property
	@PatchMapping("/employee/{id}")
	public Patient updatePatientName(@PathVariable("id") int id, @RequestBody Patient patient) {
		return patientService.updatePatientName(id, patient);
	}

}
