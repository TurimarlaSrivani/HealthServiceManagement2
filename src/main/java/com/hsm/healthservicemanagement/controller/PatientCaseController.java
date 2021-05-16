package com.hsm.healthservicemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
public class PatientCaseController {
	@Autowired
	IPatientCaseService patService;

	@PostMapping("/patients")
	public ResponseEntity<PatientCase> savePatientCase(@RequestBody PatientCase patientcase) {
		return new ResponseEntity<PatientCase>(patService.save(patientcase), HttpStatus.OK);
	}

	@DeleteMapping("/patients/{patientid}")
	public ResponseEntity<PatientCase> deletePatientCase(@PathVariable("patientid") int patientCaseId)
			throws PatientCaseNotFoundException {
		PatientCase pc = patService.deletePatientCase(patientCaseId);
		if (pc == null) {
			throw new PatientCaseNotFoundException("PatientCase not found with this id to delete" + patientCaseId);
		}
		return new ResponseEntity<PatientCase>(pc, HttpStatus.OK);

	}

	@GetMapping("/patients/all")
	public ResponseEntity<List<PatientCase>> viewAll() {
		return new ResponseEntity<List<PatientCase>>(patService.viewAll(), HttpStatus.OK);
	}

	@GetMapping("/patients/{patientid}")
	public ResponseEntity<PatientCase> viewById(@PathVariable("patientid") int Id) throws PatientCaseNotFoundException {
		PatientCase pc = patService.viewPatientCaseById(Id);
		if (pc == null) {
			throw new PatientCaseNotFoundException("PatientCase not found with this id:" + Id);
		}
		return new ResponseEntity<PatientCase>(pc, HttpStatus.OK);
	}

	@PutMapping("/patients/{patientId}")
	public ResponseEntity<PatientCase> updatePatientCaseById(@PathVariable("patientId") int patientCaseId,
			@RequestBody PatientCase patientCase) throws PatientCaseNotFoundException {
		PatientCase pc = patService.updateById(patientCaseId, patientCase);
		if (pc == null) {
			throw new PatientCaseNotFoundException("PatientCase not found with this id to update" + patientCaseId);
		}
		return new ResponseEntity<PatientCase>(pc, HttpStatus.OK);
	}

}
