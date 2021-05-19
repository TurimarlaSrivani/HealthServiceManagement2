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

import com.hsm.healthservicemanagement.entity.Medicine;
import com.hsm.healthservicemanagement.exception.MedicineNotFoundException;
import com.hsm.healthservicemanagement.service.IMedicineService;

@RestController
public class MedicineController {
	@Autowired
	IMedicineService medService;

	// READ
	@GetMapping("/medicine/id/{id}")
	public ResponseEntity<Medicine> viewMedicine(@PathVariable("id") int medicineId) throws MedicineNotFoundException {
		Medicine med = medService.viewMedicine(medicineId);
		if (med == null) {
			throw new MedicineNotFoundException("Medicine not found with this id" + medicineId);
		}
		return new ResponseEntity<Medicine>(med, HttpStatus.OK);
	}

	// showAll
	@GetMapping("/medicine")
	public ResponseEntity<List<Medicine>> showAllMedicine() {
		return new ResponseEntity<List<Medicine>>(medService.showAllMedicine(), HttpStatus.OK);
	}

	// WRITE
	@PostMapping("/medicine")
	public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine) {

		return new ResponseEntity<Medicine>(medService.addMedicine(medicine), HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/medicine/{id}")
	public ResponseEntity<Medicine> deleteMedicine(@PathVariable("id") int medicineId)
			throws MedicineNotFoundException {
		Medicine med = medService.deleteMedicine(medicineId);
		if (med == null) {
			throw new MedicineNotFoundException("Medicine not found with this id to delete" + medicineId);
		}
		return new ResponseEntity<Medicine>(med, HttpStatus.OK);
	}

	// UPDATE
	@PutMapping("/medicine/{id}")
	public ResponseEntity<Medicine> updateMedicine(@PathVariable("id") String medicineId,
			@RequestBody Medicine medicine) throws MedicineNotFoundException {
		Medicine med = medService.updateMedicine(medicine);
		if (med == null) {
			throw new MedicineNotFoundException("Medicine not found with this id to update" + medicineId);
		}
		return new ResponseEntity<Medicine>(med, HttpStatus.OK);
	}

	// UPDATE
	// Updating specific property
	@PatchMapping("/medicine/{id}")
	public ResponseEntity<Medicine> updateMedicineName(@PathVariable("id") int medicineId,
			@RequestBody Medicine medicine) throws MedicineNotFoundException {
		Medicine med = medService.updateMedicineName(medicineId, medicine);
		if (med == null) {
			throw new MedicineNotFoundException("Medicine not found with this id to update");
		}
		return new ResponseEntity<Medicine>(med, HttpStatus.OK);
	}

	// find medicine by name
	@GetMapping("/medicine/name/{name}")
	public Medicine findByMedicineName(@PathVariable("name") String medicineName) {
		return medService.findByMedicineName(medicineName);
	}

}