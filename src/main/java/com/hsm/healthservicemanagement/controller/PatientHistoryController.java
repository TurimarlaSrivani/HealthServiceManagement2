package com.hsm.healthservicemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.PatientHistory;
import com.hsm.healthservicemanagement.entity.PatientHistoryErrorResponse;
import com.hsm.healthservicemanagement.exception.PatientHistoryNotFoundException;
import com.hsm.healthservicemanagement.service.IPatientHistoryService;

@RestController
public class PatientHistoryController {

	@Autowired
	IPatientHistoryService hs;

	@PostMapping("/history")
	public ResponseEntity<PatientHistory> addPatientHistory(@RequestBody PatientHistory his) {
		return new ResponseEntity<PatientHistory>(hs.addPatientHistory(his), HttpStatus.OK);
	}

	/*
	 * @GetMapping("/history/id/{id}") public PatientHistory
	 * findByPatientId(@PathVariable("id") int patientId) {
	 * if(hs.findByPatientId(patientId)==null) throw new
	 * PatientHistoryNotFoundException("Patient History not found with given patient Id :"
	 * +patientId); return hs.findByPatientId(patientId); }
	 */

	@GetMapping("/history/all")
	public List<PatientHistory> getAllPatientHistory() {
		return hs.getAllPatientHistory();
	}

	@GetMapping("/history/{id}")
	public PatientHistory findByPatientHistoryId(@PathVariable("id") int patientHistoryId) {
		if (hs.findByPatientHistoryId(patientHistoryId) == null)
			throw new PatientHistoryNotFoundException(
					"Patient History not found with given patient Id :" + patientHistoryId);
		return hs.findByPatientHistoryId(patientHistoryId);
	}

	@DeleteMapping("/history/{id}")
	public String deleteByPatientHistoryId(@PathVariable("id") int patientHistoryId) {
		String s = hs.deleteByPatientHistoryId(patientHistoryId);
		if (s == null)
			throw new PatientHistoryNotFoundException(
					"Patient History not found with given patient Id :" + patientHistoryId);
		return s;
	}

	@PutMapping("/history/{id}")
	public PatientHistory updatePatientHistory(@PathVariable("id") int patientHistoryId,
			@RequestBody PatientHistory his) {
		if (hs.findByPatientHistoryId(patientHistoryId) == null)
			throw new PatientHistoryNotFoundException(
					"Patient History not found with given patient Id :" + patientHistoryId);
		return hs.updatePatientHistory(his);
	}
	
	@GetMapping("/history/id/{id}")
	public PatientHistory findByPatientId(@PathVariable("id") int patientId)
	{
		if(hs.findByPatientId(patientId)==null)
			throw new PatientHistoryNotFoundException("Patient History not found with given patient Id :"+patientId);
		return hs.findByPatientId(patientId);
	}

}
