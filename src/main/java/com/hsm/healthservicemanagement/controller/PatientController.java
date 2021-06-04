package com.hsm.healthservicemanagement.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.Patient;
import com.hsm.healthservicemanagement.exception.PatientNotFoundException;
import com.hsm.healthservicemanagement.service.IPatientService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PatientController {

	// Logger Declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PatientController.class);

	// We use @Autowired the patient service layer to this controller layer of
	// patient
	@Autowired
	IPatientService patientService;

	// This controller is used to get a specific patient on basis of ID.
	// findByPatientId

	@GetMapping("/patient/id/{id}")
	public Patient findByPatientId(@PathVariable("id") int patientId) {
		// setting logger info
		logger.info("Get the patient details By Id");

		if (patientService.findByPatientId(patientId) == null) {
			throw new PatientNotFoundException("Patient not found with given id: " + patientId);
		}
		return patientService.findByPatientId(patientId);
	}

	// This controller is used to create a new or add new patient and redirects it
	// to the service layer.
	// save patient

	@PostMapping("/patient/add")
	public Patient addPatient(@RequestBody Patient patient) {
		// setting logger info
		logger.info("save the details of the patient");
		return patientService.save(patient);
	}

	// This controller is used to return and list all the patient found in the
	// database and request to the service to perform the action.
	// find/viewAllPatientDetails

	@GetMapping("/patient")
	public List<Patient> findAll() {
		// setting logger info
		logger.info("Find the details of the patient");

		return patientService.findAll();
	}

	// This controller function perform deletion of a specific given patient
	// and request the service to perform the action and return the message as
	// deleted else throw exception.
	// deleteByPatientId

	@DeleteMapping("/patient/{id}")
	public Patient deleteByPatientId(@PathVariable("id") int patientId) {
		// setting logger info
		logger.info(" delete the patient By Id");

		if (patientService.deleteByPatientId(patientId) == null) {
			throw new PatientNotFoundException("Patient not found with given id: " + patientId);
		}
		return patientService.deleteByPatientId(patientId);

	}

	// This controller is used to get a specific patient on basis of name.
	// find by PatientName
	@GetMapping("/patient/{name}")
	public Patient findByPatientName(@PathVariable("name") String name) {
		// setting logger info
		logger.info("Get the patient details By name");

		if (patientService.findByPatientName(name) == null) {
			throw new PatientNotFoundException("Patient not found with given name: " + name);
		}
		return patientService.findByPatientName(name);
	}

	// This function is used to update a specific patient on basis of given
	// patient id and returns exception if given patient id is not found.
	// UPDATE
	// Updating specific property
	// updatePatientId

	@PatchMapping("/patient/id/{id}")
	public Patient updateByPatientId(@PathVariable("id") int patientId) {
		// setting logger info
		logger.info("update the specific property by id");

		if (patientService.updateByPatientId(patientId) == null) {
			throw new PatientNotFoundException("Patient not found with given id: " + patientId);
		}
		return patientService.updateByPatientId(patientId);

	}

	// This function is used to update a specific patient on basis of given
	// patient name and returns exception if given patient name is not found.
	// UPDATE
	// Updating specific property
	// updatePatientName

	@PatchMapping("/patient/{name}")
	public Patient updatePatientName(@PathVariable("name") int id, @RequestBody Patient patient) {
		// setting logger info
		logger.info("update the specific property by name");

		if (patientService.updatePatientName(id, patient) == null) {
			throw new PatientNotFoundException("Patient not found with given name: " + patient);
		}
		return patientService.updatePatientName(id, patient);
	}

}