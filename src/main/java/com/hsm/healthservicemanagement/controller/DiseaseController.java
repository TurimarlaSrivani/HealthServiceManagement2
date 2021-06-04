package com.hsm.healthservicemanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
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

import com.hsm.healthservicemanagement.entity.Disease;
import com.hsm.healthservicemanagement.exception.*;
import com.hsm.healthservicemanagement.service.IDiseaseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DiseaseController {
	// Logger Declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(DiseaseController.class);

	// We are autowiring the disease service layer to this controller layer of
	// disease
	@Autowired
	IDiseaseService diseaseService;

	// This controller is used to get a specific disease on basis of ID.
	// viewByDiseaseId
	@GetMapping("/disease/{id}")
	public ResponseEntity<Disease> findByDiseaseId(@PathVariable("id") int id) throws DiseaseNotFoundException {
		// setting logger info
		logger.info("Get the disease details By Id");

		Disease disease = diseaseService.findByDiseaseId(id);
		if (disease == null) {
			throw new DiseaseNotFoundException("Disease not found with given id:" + id);
		}
		return new ResponseEntity<Disease>(disease, HttpStatus.OK);
	}

	// This controller is used to return and list all the disease found in the
	// database and request to the service to perform the action.
	// viewAllDiseaseDetails
	@GetMapping("/disease")
	public ResponseEntity<List<Disease>> findAll() {
		// setting logger info
		logger.info("Find the details of the disease");

		return new ResponseEntity<List<Disease>>(diseaseService.findAll(), HttpStatus.OK);
	}

	// This controller is used to create a new or add new disease and redirects it
	// to the service layer.
	// save disease

	@PostMapping("/disease")
	public ResponseEntity<Disease> saveDiet(@Valid @RequestBody Disease disease) {
		// setting logger info
		logger.info("save the details of the disease");

		return new ResponseEntity<Disease>(diseaseService.save(disease), HttpStatus.OK);
	}

	// This controller function perform deletion of a specific given disease
	// and request the service to perform the action and return the message as
	// deleted else throw exception.
	// deleteDiseaseById
	@DeleteMapping("/disease/{id}")
	public ResponseEntity<Disease> deleteByDiseaseId(@PathVariable("id") int id) throws DiseaseNotFoundException {

		// setting logger info
		logger.info(" delete the disease By Id");

		Disease disease = diseaseService.deleteByDiseaseId(id);
		if (disease == null) {
			throw new DiseaseNotFoundException("Disease not found with this id to delete" + id);

		}

		return new ResponseEntity<Disease>(disease, HttpStatus.OK);
	}

	// This function is used to update a specific disease on basis of given
	// disease id and returns exception if given disease id is not found.
	// UPDATE
	// Updating specific property
	// updateDiseaseId
	@PatchMapping("/disease/diseaseId/{id}")
	public ResponseEntity<Disease> updateDiseaseId(@PathVariable("id") int id, @RequestBody Disease disease)
			throws DiseaseNotFoundException {
		// setting logger info
		logger.info("update the specific property by id");

		Disease diseases = diseaseService.updateDiseaseId(id, disease);
		if (diseases == null) {
			throw new DiseaseNotFoundException("Disease not found with this id to update");
		}
		return new ResponseEntity<Disease>(diseases, HttpStatus.OK);
	}

	// This function is used to update a specific disease on basis of given
	// disease name and returns exception if given disease id is not found.
	// UPDATE
	// Updating specific property
	// updateDiseaseName
	@PatchMapping("/disease/diseaseName/{id}")
	public ResponseEntity<Disease> updateDiseaseName(@PathVariable("id") int id, @RequestBody Disease disease)
			throws DiseaseNotFoundException {
		// setting logger info
		logger.info("update the specific property by name");

		Disease diseases = diseaseService.updateDiseaseName(id, disease);
		if (diseases == null) {
			throw new DiseaseNotFoundException("Disease not found with this name to update");
		}
		return new ResponseEntity<Disease>(diseases, HttpStatus.OK);
	}

	// This function is used to update a specific disease on basis of given
	// disease type and returns exception if given disease id is not found.
	// UPDATE
	// Updating specific property
	// updateDiseaseType
	@PatchMapping("/disease/diseaseType/{id}")
	public ResponseEntity<Disease> updateDiseaseType(@PathVariable("id") int id, @RequestBody Disease disease)
			throws DiseaseNotFoundException {
		// setting logger info
		logger.info("update the specific property by type");

		Disease diseases = diseaseService.updateDiseaseType(id, disease);
		if (diseases == null) {
			throw new DiseaseNotFoundException("Disease not found with this type to update");
		}
		return new ResponseEntity<Disease>(diseases, HttpStatus.OK);
	}

	// This function is used to update a specific disease on basis of given
	// disease symptoms and returns exception if given disease id is not found.
	// UPDATE
	// Updating specific property
	// updateDiseaseSymptoms
	@PatchMapping("/disease/diseaseSymptoms/{id}")
	public ResponseEntity<Disease> updateDiseaseSymptoms(@PathVariable("id") int id, @RequestBody Disease disease)
			throws DiseaseNotFoundException {
		// setting logger info
		logger.info("update the specific property by symptoms");

		Disease diseases = diseaseService.updateDiseaseSymptoms(id, disease);
		if (diseases == null) {
			throw new DiseaseNotFoundException("Disease not found with this symptoms to update");
		}
		return new ResponseEntity<Disease>(diseases, HttpStatus.OK);
	}

	// This function is used to update a specific disease on basis of given
	// disease id and returns exception if given disease id is not found.
	// updateDisease
	@PutMapping("/disease")
	public ResponseEntity<Disease> updateDisease(@PathVariable("id") int id, @RequestBody Disease disease)
			throws DiseaseNotFoundException {

		// setting logger info
		logger.info("update the disease details by id");
		Disease diseases = diseaseService.update(disease);
		if (diseases == null) {
			throw new DiseaseNotFoundException("Disease not found with this id to update" + id);

		}
		return new ResponseEntity<Disease>(diseases, HttpStatus.OK);
	}

}