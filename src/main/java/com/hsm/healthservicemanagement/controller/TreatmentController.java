package com.hsm.healthservicemanagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.hsm.healthservicemanagement.entity.Treatment;
import com.hsm.healthservicemanagement.entity.TreatmentStatus;
import com.hsm.healthservicemanagement.service.ITreatmentService;
import com.hsm.healthservicemanagement.exception.TreatmentNotFoundException;

@RestController
@CrossOrigin
public class TreatmentController {

	@Autowired
	ITreatmentService treatmentService;

	// WRITE
	// saveTreatment
	@PostMapping("/treatment")
	public ResponseEntity<Treatment> save(@RequestBody Treatment treatment) {
		return new ResponseEntity<>(treatmentService.save(treatment), HttpStatus.OK);
	}

	// deleteTreatmentByTreatmentId
	@DeleteMapping("/treatment/delId/{treatmentId}")
	public ResponseEntity<Treatment> deleteTreatmentByTreatmentId(@PathVariable int treatmentId) {
		if (treatmentService.findByTreatmentId(treatmentId) == null) {
			throw new TreatmentNotFoundException("Treatment not found with this id");
		}
		return new ResponseEntity<>(treatmentService.deleteTreatmentByTreatmentId(treatmentId), HttpStatus.OK);
	}

	// updateAllTreatmentdata
	@PatchMapping("/treatment/{treatmentId}")
	public ResponseEntity<Treatment> updateTreatment(@PathVariable int treatmentId, @RequestBody Treatment treatment) {
		if (treatmentService.findByTreatmentId(treatmentId) == null) {
			throw new TreatmentNotFoundException("Treatment not found with this id");
		}
		return new ResponseEntity<>(treatmentService.updateTreatment(treatment), HttpStatus.OK);
	}

	// updateTreatmentDateByTreatmentId
	@PutMapping("/treatment/{treatmentId}")
	public ResponseEntity<Treatment> updateTreatmentDateByTreatmentId(@PathVariable int treatmentId,
			@RequestBody Treatment treatment) {
		if (treatmentService.findByTreatmentId(treatmentId) == null) {
			throw new TreatmentNotFoundException("Treatment not found with this id to update");
		}
		return new ResponseEntity<>(treatmentService.updateTreatmentDateByTreatmentId(treatmentId, treatment),
				HttpStatus.OK);
	}

	// updateTreatmentStatusByTreatmentId
	@PutMapping("/treatment/stat/{treatmentId}")
	public ResponseEntity<Treatment> updateTreatmentStatusByTreatmentId(@PathVariable int treatmentId,
			@RequestBody Treatment treatment) {
		if (treatmentService.findByTreatmentId(treatmentId) == null) {
			throw new TreatmentNotFoundException("Id Not Found");
		}
		return new ResponseEntity<>(treatmentService.updateTreatmentStatusByTreatmentId(treatmentId, treatment),
				HttpStatus.OK);
	}

	// Read
	// findAlltreatmentDetails
	@GetMapping("/treatment")
	public ResponseEntity<List<Treatment>> findAllTreatment() {
		return new ResponseEntity<>(treatmentService.findAllTreatment(), HttpStatus.OK);
	}

	// findByTreatmentId
	@GetMapping("/treatment/getTId/{treatmentId}")
	public ResponseEntity<Treatment> findByTreatmentId(@PathVariable int treatmentId) {
		if (treatmentService.findByTreatmentId(treatmentId) == null) {
			throw new TreatmentNotFoundException("TREATMENT NOT FOUND WITH THIS ID: " + treatmentId);
		}
		return new ResponseEntity<>(treatmentService.findByTreatmentId(treatmentId), HttpStatus.OK);
	}

	// findByTreatmentDate
	@GetMapping("/treatment/getDate/{treatmentDate}")
	public ResponseEntity<List<Treatment>> findByTreatmentDate(
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("treatmentDate") LocalDate treatmentDate) {
		if (treatmentService.findByTreatmentDate(treatmentDate) == null) {
			throw new TreatmentNotFoundException("NO TREATMENT SCHEDULED ON: " + treatmentDate);
		}
		return new ResponseEntity<>(treatmentService.findByTreatmentDate(treatmentDate), HttpStatus.OK);
	}

	// findByTreatmentStatus
	@GetMapping("/treatment/status/{treatmentStatus}")
	public ResponseEntity<List<Treatment>> findByTreatmentStatus(@PathVariable TreatmentStatus treatmentStatus) {
		if (treatmentService.findByTreatmentStatus(treatmentStatus) == null) {
			throw new TreatmentNotFoundException("PATIENT STATUS NOT FOUND: " + treatmentStatus);
		}
		return new ResponseEntity<>(treatmentService.findByTreatmentStatus(treatmentStatus), HttpStatus.OK);

	}
}
