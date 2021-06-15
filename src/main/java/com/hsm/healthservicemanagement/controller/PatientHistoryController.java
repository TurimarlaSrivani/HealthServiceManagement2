package com.hsm.healthservicemanagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.Patient;
import com.hsm.healthservicemanagement.entity.PatientHistory;
import com.hsm.healthservicemanagement.exception.PatientHistoryNotFoundException;
import com.hsm.healthservicemanagement.service.IPatientHistoryService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PatientHistoryController {

	// Logger Declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PatientHistoryController.class);

	// We are autowiring patientHistory service layer to this controller layer of
	// patientHistory
	@Autowired
	IPatientHistoryService service;

	// This controller is used to create or add new patient history
	// and redirects it to the service layer.
	// addPatientHistory

	@PostMapping("/history/add")
	public ResponseEntity<PatientHistory> addPatientHistory(@RequestBody PatientHistory history) {
		// setting logger info
		logger.info("Patient history details created");
		return new ResponseEntity<PatientHistory>(service.addPatientHistory(history), HttpStatus.OK);
	}

	// This controller is used to return and list all the patient history found in
	// the
	// database and request to the service to perform the action.
	// getAllPatientHistory

	@GetMapping("/history")
	public List<PatientHistory> getAllPatientHistory() {
		// setting logger info
		logger.info("Find the details of the patient history");
		return service.getAllPatientHistory();
	}

	// This controller is used to get a specific patient history on basis of ID.
	// findByPatientHistoryId

	@GetMapping("/history/{id}")
	public PatientHistory findByPatientHistoryId(@PathVariable("id") int patientHistoryId) {
		// setting logger info
		logger.info("Get the patient history details By Id ");
		if (service.findByPatientHistoryId(patientHistoryId) == null)
			throw new PatientHistoryNotFoundException(
					"Patient History not found with given patient Id" + patientHistoryId);
		return service.findByPatientHistoryId(patientHistoryId);
	}

	
	// This controller is used to get a specific patient history on basis of date.
	// findByRecordedDate

	@GetMapping("/history/date/{date}")
	public List<PatientHistory> findByRecordedDate(
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate recordedDate) {

		logger.info("Get the patient history details By date ");
		if (service.findByRecordedDate(recordedDate) == null) {
			throw new PatientHistoryNotFoundException("Patient History not found with given date :" + recordedDate);
		}
		return service.findByRecordedDate(recordedDate);

	}

	// This controller function perform deletion of a specific given patient history
	// and request the service to perform the action and return the message as
	// deleted else throw exception.
	// deleteByPatientHistoryId

	@DeleteMapping("/history/{id}")
	public String deleteByPatientHistoryId(@PathVariable("id") int patientHistoryId) {
		// setting logger info
		logger.info("Patient history deleted with Id ");
		String s = service.deleteByPatientHistoryId(patientHistoryId);
		if (s == null)
			throw new PatientHistoryNotFoundException(
					"Patient History not found with given patient Id :" + patientHistoryId);
		return s;
	}

	// This function is used to update a specific patient history on basis of given
	// patientHistoryId and returns exception if given patientHistoryId is not
	// found.
	// updatePatientHistory

	@PutMapping("/history/{id}")
	public PatientHistory updatePatientHistory(@PathVariable("id") int patientHistoryId,
			@RequestBody PatientHistory history) {
		// setting logger info
		logger.info("Patient history details updated by id " + patientHistoryId);
		if (service.findByPatientHistoryId(patientHistoryId) == null)
			throw new PatientHistoryNotFoundException(
					"Patient History not found with given patient Id :" + patientHistoryId);
		return service.updatePatientHistory(history);
	}

}