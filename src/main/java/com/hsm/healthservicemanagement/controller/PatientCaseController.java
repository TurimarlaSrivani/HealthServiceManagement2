package com.hsm.healthservicemanagement.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.hsm.healthservicemanagement.entity.PatientCase;
import com.hsm.healthservicemanagement.exception.PatientCaseNotFoundException;
import com.hsm.healthservicemanagement.service.IPatientCaseService;

@CrossOrigin
@RestController
public class PatientCaseController {

	// Logger Declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PatientCaseController.class);
	// We are autoWiring the patientCase service layer to this controller layer of
	// patientCase
	@Autowired
	IPatientCaseService patService;

	// This controller is used to create a new or add new patientCase and redirects
	// it
	// to the service layer.
	// save patientCase
	@PostMapping("/patientCase")
	public ResponseEntity<PatientCase> savePatientCase(@RequestBody PatientCase patientcase) {
		// setting logger info
		logger.info("save the details of the patientCase");

		return new ResponseEntity<PatientCase>(patService.save(patientcase), HttpStatus.OK);
	}

	// This controller function perform deletion of a specific given patientCase
	// and request the service to perform the action and return the message as
	// deleted else throw exception.
	// deletePatientCaseByPatientCaseId
	@DeleteMapping("/patientCase/{patientid}")
	public ResponseEntity<PatientCase> deletePatientCase(@PathVariable("patientid") int patientCaseId)
			throws PatientCaseNotFoundException {

		// setting logger info
		logger.info(" delete the delete PatientCase By Id");

		PatientCase pc = patService.deletePatientCase(patientCaseId);
		if (pc == null) {
			throw new PatientCaseNotFoundException("PatientCase not found with this id to delete" + patientCaseId);
		}
		return new ResponseEntity<PatientCase>(pc, HttpStatus.OK);

	}

	// This controller is used to return and list all the patientCase found in the
	// database and request to the service to perform the action.
	// viewAllPatientCaseDetails
	@GetMapping("/patientCase")
	public ResponseEntity<List<PatientCase>> viewAll() {
		// setting logger info
		logger.info("Find the details of the patientCase");

		return new ResponseEntity<List<PatientCase>>(patService.viewAll(), HttpStatus.OK);
	}

	// This controller is used to get a specific patientCase on basis of Id.
	// viewByPatientCaseId
	@GetMapping("/patientCase/{patientid}")
	public ResponseEntity<PatientCase> viewById(@PathVariable("patientid") int Id) throws PatientCaseNotFoundException {
		// setting logger info
		logger.info("Get the patientCase details By Id");

		PatientCase pc = patService.viewPatientCaseById(Id);
		if (pc == null) {
			throw new PatientCaseNotFoundException("PatientCase not found with this id:" + Id);
		}
		return new ResponseEntity<PatientCase>(pc, HttpStatus.OK);
	}

	// This function is used to update a specific patientCase on basis of given
	// patientCase id and returns exception if given patientCase id is not found.
	// updatePatientCase
	@PutMapping("/patientCase/{patientId}")
	public ResponseEntity<PatientCase> update(@PathVariable("patientId") int patientCaseId,

			@RequestBody PatientCase patientCase) throws PatientCaseNotFoundException {
		// setting logger info
		logger.info("update the patientCase details by id");
		PatientCase pc = patService.update( patientCase);
		if (pc == null) {
			throw new PatientCaseNotFoundException("PatientCase not found with this id to update" );
		}
		return new ResponseEntity<PatientCase>(pc, HttpStatus.OK);
	}
}