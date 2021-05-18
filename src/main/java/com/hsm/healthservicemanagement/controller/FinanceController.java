package com.hsm.healthservicemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.Finance;
import com.hsm.healthservicemanagement.exception.FinanceNotFoundException;
import com.hsm.healthservicemanagement.service.IFinanceService;

@RestController
@CrossOrigin
public class FinanceController {

	@Autowired
	IFinanceService financeService;

	// READ
	// findByPatientId
	@GetMapping("/finance/id/{patientid}")
	public ResponseEntity<Finance> findByPatientId(@PathVariable("patientid") int patientId)
			throws FinanceNotFoundException {
		Finance fin = financeService.findByPatientId(patientId);
		if (fin == null) {
			throw new FinanceNotFoundException("FINANCE NOT FOUND WITH THIS ID: " + patientId);
		}
		return new ResponseEntity<>(fin, HttpStatus.OK);
	}

	// findAllFinanceDetails
	@GetMapping("/finance")
	public ResponseEntity<List<Finance>> findAllFinanceDetails() {
		return new ResponseEntity<>(financeService.findAllFinanceDetails(), HttpStatus.OK);
	}

	// WRITE
	// save
	@PostMapping("/finance")
	public ResponseEntity<Finance> save(@RequestBody Finance finance) {
		return new ResponseEntity<>(financeService.save(finance), HttpStatus.OK);
	}

	// DELETE
	// deleteFinanceByPatientId
	@DeleteMapping("/finance/{patientid}")
	public ResponseEntity<Finance> deleteFinanceByPatientId(@PathVariable("patientid") int patientId)
			throws FinanceNotFoundException {
		Finance fin = financeService.deleteFinanceByPatientId(patientId);
		if (fin == null) {
			throw new FinanceNotFoundException("Finance not found with this id to delete");
		}
		return new ResponseEntity<>(fin, HttpStatus.OK);
	}

	// UPDATE
	// entire/all property
	@PutMapping("/finance/id/{financeid}")
	public ResponseEntity<Finance> updateFinance(@PathVariable("financeid") int financeId, @RequestBody Finance finance)
			throws FinanceNotFoundException {
		Finance fin = financeService.updateFinance(finance);
		if (fin == null) {
			throw new FinanceNotFoundException("Finance not found with given finance id: " + financeId);
		}
		return new ResponseEntity<>(fin, HttpStatus.OK);
	}

	// updating specific property
	@PatchMapping("/finance/{financeid}")
	public ResponseEntity<Finance> updateFinanceByPatientName(@PathVariable("financeid") int financeId,
			@RequestBody Finance finance) throws FinanceNotFoundException {
		Finance fin = financeService.updateFinanceByPatientName(financeId, finance);
		if (fin == null) {
			throw new FinanceNotFoundException("Finance not found with given id to update!");
		}
		return new ResponseEntity<>(fin, HttpStatus.OK);
	}

	// find patient by name
	@GetMapping("/finance/name/{patientName}")
	public ResponseEntity<Finance> findByPatientName(@PathVariable("patientName") String patientName)
			throws FinanceNotFoundException {
		Finance fin = financeService.findByPatientName(patientName);
		if (fin == null) {
			throw new FinanceNotFoundException("Finance not found with given name: " + patientName);
		}
		return new ResponseEntity<>(fin, HttpStatus.OK);
	}

}
