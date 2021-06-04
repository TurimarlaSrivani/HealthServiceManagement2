package com.hsm.healthservicemanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.hsm.healthservicemanagement.entity.Finance;
import com.hsm.healthservicemanagement.exception.FinanceNotFoundException;
import com.hsm.healthservicemanagement.service.IFinanceService;

@CrossOrigin
@RestController

public class FinanceController {

	// Logger Declare
	Logger logger = LogManager.getLogger();

	// We are autowiring the finance service layer to this controller layer of
	// finance
	@Autowired
	IFinanceService financeService;

	// This controller is used to get a specific finance on basis of ID.
	// READ
	// findByFinanceId
	@GetMapping("/finance/{financeid}")
	public ResponseEntity<Finance> findByFinanceId(@PathVariable("financeid") int financeId)
			throws FinanceNotFoundException {
		// setting logger info
		logger.info("Get the finance details By Id");
		Finance fin = financeService.findByFinanceId(financeId);
		if (fin == null) {
			throw new FinanceNotFoundException("FINANCE NOT FOUND WITH THIS ID: " + financeId);
		}
		return new ResponseEntity<>(fin, HttpStatus.OK);
	}

	// This controller is used to return and list all the finance found in the
	// database and request to the service to perform the action.
	// findAllFinanceDetails
	@GetMapping("/finance")
	public ResponseEntity<List<Finance>> findAllFinanceDetails() {
		// setting logger info
		logger.info("Find the details of the Finance");
		return new ResponseEntity<>(financeService.findAllFinanceDetails(), HttpStatus.OK);
	}

	// This controller is used to create a new or add new finance and redirects it
	// to the service layer.
	// WRITE
	// save
	@PostMapping("/finance")
	public ResponseEntity<Finance> save(@Valid @RequestBody Finance finance) {
		// setting logger info
		logger.info("Save he details of the finance");
		return new ResponseEntity<>(financeService.save(finance), HttpStatus.OK);
	}

	// This controller function perform deletion of a specific given finance id
	// and request the service to perform the action and return the message as
	// deleted else throw exception.
	// DELETE
	// deleteFinanceByFinanceId
	@DeleteMapping("/finance/{financeid}")
	public ResponseEntity<Finance> deleteFinanceByFinanceId(@PathVariable("financeid") int financeId)
			throws FinanceNotFoundException {

		// setting logger info
		logger.info(" Delete the Finance by Id");

		Finance fin = financeService.deleteFinanceByFinanceId(financeId);
		if (fin == null) {
			throw new FinanceNotFoundException("Finance not found with this id to delete" + financeId);
		}
		return new ResponseEntity<>(fin, HttpStatus.OK);
	}

	// This function is used to update finance on basis of given
	// finance id and returns exception if given finance id is not found.
	// UPDATE
	// updateFinance
	// entire/all property
	@PutMapping("/finance/{financeid}")
	public ResponseEntity<Finance> updateFinance(@PathVariable("financeid") int financeId, @RequestBody Finance finance)
			throws FinanceNotFoundException {
		// setting logger info
		logger.info("Update the finance details By Id");
		Finance fin = financeService.updateFinance(finance);
		if (fin == null) {
			throw new FinanceNotFoundException("Finance not found with given finance id: " + financeId);
		}
		return new ResponseEntity<>(fin, HttpStatus.OK);
	}

	// custom method // findByPatientName

	@GetMapping("/finance/{patientname}")
	public List<Finance> findByPatientName(@PathVariable("patientname") String patientName) {
		// setting logger info
		logger.info("Find the details of the Finance");
		return (financeService.findByPatientName(patientName));
		// return new ResponseEntity<>(financeService.findByPatientName(patientName)),
		// HttpStatus.OK);
	}

}