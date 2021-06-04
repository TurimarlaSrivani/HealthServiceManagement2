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
import com.hsm.healthservicemanagement.entity.Diet;
import com.hsm.healthservicemanagement.exception.DietNotFoundException;
import com.hsm.healthservicemanagement.service.IDietService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class DietController {

	// Logger Declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(DietController.class);

	// We are autowiring the diet service layer to this controller layer of diet
	@Autowired
	IDietService ds;

	// This controller is used to create a new or add new diet and redirects it
	// to the service layer.
	// save diet

	@PostMapping("/diet")
	public ResponseEntity<Diet> saveDiet(@Valid @RequestBody Diet diet) {
		// setting logger info
		logger.info("save the details of the diet");

		return new ResponseEntity<Diet>(ds.save(diet), HttpStatus.OK);
	}

	// This controller function perform deletion of a specific given diet
	// and request the service to perform the action and return the message as
	// deleted else throw exception.
	// deleteDietByDietId

	@DeleteMapping("/diet/{id}")
	public ResponseEntity<Diet> deleteDiet(@PathVariable("id") int id) throws DietNotFoundException {

		// setting logger info
		logger.info(" delete the delete Diet By Id");

		Diet dt = ds.deleteDiet(id);
		if (dt == null) {
			throw new DietNotFoundException("Diet not found with this id to delete" + id);

		}

		return new ResponseEntity<Diet>(dt, HttpStatus.OK);
	}

	// This controller is used to return and list all the diet found in the
	// database and request to the service to perform the action.
	// viewAllDietDetails

	@GetMapping("/diet")
	public ResponseEntity<List<Diet>> viewAll() {
		// setting logger info
		logger.info("Find the details of the diet");

		return new ResponseEntity<List<Diet>>(ds.viewAll(), HttpStatus.OK);
	}

	// This controller is used to get a specific diet on basis of ID.
	// viewByDietId

	@GetMapping("/diet/{id}")
	public ResponseEntity<Diet> viewById(@PathVariable("id") int id) throws DietNotFoundException {
		// setting logger info
		logger.info("Get the diet detyails By Id");

		Diet dt = ds.viewDietById(id);
		if (dt == null) {
			throw new DietNotFoundException("Diet not found with given id:" + id);
		}
		return new ResponseEntity<Diet>(dt, HttpStatus.OK);
	}

	// This function is used to update a specific diet on basis of given
	// diet id and returns exception if given diet id is not found.
	// updateDiet

	@PutMapping("/diet/{id}")
	public ResponseEntity<Diet> updateDiet(@PathVariable("id") int id, @RequestBody Diet diet)
			throws DietNotFoundException {

		// setting logger info
		logger.info("update the diet details by id");
		Diet dt = ds.updateDiet(diet);
		if (dt == null) {
			throw new DietNotFoundException("Diet not found with this id to update" + id);

		}
		return new ResponseEntity<Diet>(dt, HttpStatus.OK);
	}

	// This function is used to update a specific diet on basis of given
	// diet type and returns exception if given diet id is not found.
	// UPDATE
	// Updating specific property
	// updateDietType

	@PatchMapping("/diet/{id}")
	public ResponseEntity<Diet> updateDietType(@PathVariable("id") int id, @RequestBody Diet diet)
			throws DietNotFoundException {
		// setting logger info
		logger.info("update the specific property by id");

		Diet dt = ds.updateDietType(id, diet);
		if (dt == null) {
			throw new DietNotFoundException("Diet not found with this id to update");
		}
		return new ResponseEntity<Diet>(dt, HttpStatus.OK);
	}
}