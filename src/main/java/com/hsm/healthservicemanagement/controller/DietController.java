package com.hsm.healthservicemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController

public class DietController {

	@Autowired
	IDietService ds;

	// WRITE
	// save
	@PostMapping("/diet")
	public ResponseEntity<Diet> saveDiet(@RequestBody Diet diet) {
		return new ResponseEntity<Diet>(ds.save(diet), HttpStatus.OK);
	}

	// DELETE
	// deleteDietByDietId
	@DeleteMapping("/diet/{id}")
	public ResponseEntity<Diet> deleteDiet(@PathVariable("id") int id) throws DietNotFoundException {
		Diet dt = ds.deleteDiet(id);
		if (dt == null) {
			throw new DietNotFoundException("Diet not found with this id to delete" + id);

		}

		return new ResponseEntity<Diet>(dt, HttpStatus.OK);
	}

	// Read
	// viewAllDietDetails
	@GetMapping("/diet")
	public ResponseEntity<List<Diet>> viewAll() {
		return new ResponseEntity<List<Diet>>(ds.viewAll(), HttpStatus.OK);
	}

	// viewByDietId
	@GetMapping("/diet/{id}")
	public ResponseEntity<Diet> viewById(@PathVariable("id") int id) throws DietNotFoundException {
		Diet dt = ds.viewDietById(id);
		if (dt == null) {
			throw new DietNotFoundException("Diet not found with given id:" + id);
		}
		return new ResponseEntity<Diet>(dt, HttpStatus.OK);
	}

	// UPDATE
	// updateDiet
	@PutMapping("/diet/{id}")
	public ResponseEntity<Diet> updateDiet(@PathVariable("id") int id, @RequestBody Diet diet)
			throws DietNotFoundException {

		Diet dt = ds.updateDiet(diet);
		if (dt == null) {
			throw new DietNotFoundException("Diet not found with this id to update" + id);

		}
		return new ResponseEntity<Diet>(dt, HttpStatus.OK);
	}

	// UPDATE
	// Updating specific property
	// updateDietType
	@PatchMapping("/diet/{id}")
	public ResponseEntity<Diet> updateDietType(@PathVariable("id") int id, @RequestBody Diet diet)
			throws DietNotFoundException {

		Diet dt = ds.updateDietType(id, diet);
		if (dt == null) {
			throw new DietNotFoundException("Diet not found with this id to update");
		}
		return new ResponseEntity<Diet>(dt, HttpStatus.OK);
	}
}