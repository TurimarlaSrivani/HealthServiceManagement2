package com.hsm.healthservicemanagement.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.Disease;
import com.hsm.healthservicemanagement.entity.DiseaseErrorResponse;
import com.hsm.healthservicemanagement.exception.*;
//import com.cg.hsm.service.DiseaseServiceImpl;
import com.hsm.healthservicemanagement.service.IDiseaseService;


@RestController
public class DiseaseController {

	@Autowired
	IDiseaseService desService;
	
	@ExceptionHandler
	public ResponseEntity<DiseaseErrorResponse> handleException(DiseaseNotFoundException exception){
		DiseaseErrorResponse error = new DiseaseErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// READ
	@GetMapping("/disease/{id}")
	public Disease findDiseaseById(@PathVariable("id") int desId) {
		return desService.findByDesId(desId);
	}
	
	@GetMapping("/disease")
	public List<Disease> findAllDisease() {
		return desService.findAll();
	}
	
	// WRITE
	@PostMapping("/disease")
	public Disease addDisease(@RequestBody Disease disease) {
		return desService.save(disease);
	}
	
	// DELETE
	@DeleteMapping("/disease/{id}")
	public Disease deleteDisease(@PathVariable("id") int desId) {
		return desService.deleteByDesId(desId);
	}
	
	// UPDATE
	// Updating specific property
	@PatchMapping("/disease/desId/{id}")
	public Disease updatedesId(@PathVariable("id") int id, @RequestBody Disease disease) {
		return desService.updateDesId(id, disease);
	}
	
	@PatchMapping("/disease/desName/{id}")
	public Disease updateDesName(@PathVariable("id") int id, @RequestBody Disease disease) {
		return desService.updateDesName(id, disease);
	}
	
	@PatchMapping("/disease/desType/{id}")
	public Disease updatedesType(@PathVariable("id") int id, @RequestBody Disease disease) {
		return desService.updateDesType(id, disease);
	}
	@PatchMapping("/disease/desSym/{id}")
	public Disease updatedesSym(@PathVariable("id") int id, @RequestBody Disease disease) {
		return desService.updateDesSym(id, disease);
	}
	@PatchMapping("/disease/desDur/{id}")
	public Disease updateDesDur(@PathVariable("id") int id, @RequestBody Disease disease) {
		return desService.updateDesDur(id, disease);
	}
	// Update
	@PutMapping("/disease/DesName/{id}") 
	public Disease updatedesName(@PathVariable("id") int id, @RequestBody Disease disease) {
		return desService.update(disease);
	}
	/*@GetMapping("/disease/{desId}")
	findAllPatientCasesByDiseaseId(int diseaseId): List<PatientCase>
	
	
	@GetMapping("/patientCase/{patientCaseId}/disease/{diseaseId}/treatment")
	findPatientCaseTreatmentByDiseaseId(int patientCaseId,int diseaseId): String
	
	@GetMapping("/patientCase/{patientCaseId}/disease/{diseaseId}/medicines")
	findPatientCaseMedicinesByDiseaseId(int patientCaseId,int diseaseId): String
	
	@GetMapping("/patientCase/{patientCaseId}/disease/{diseaseId}/doctor")
	findPatientCaseDoctorByDiseaseId(int patientCaseId,int diseaseId): String*/
}






