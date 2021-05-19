package com.hsm.healthservicemanagement.controller;

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

import com.hsm.healthservicemanagement.entity.Doctor;
import com.hsm.healthservicemanagement.entity.HmsErrorResponse;
import com.hsm.healthservicemanagement.exception.DoctorNotFoundException;
import com.hsm.healthservicemanagement.service.IDoctorService;

import java.util.List;

@RestController
public class DoctorController {

	@Autowired
	IDoctorService doctService;

	@ExceptionHandler
	public ResponseEntity<HmsErrorResponse> handleException(DoctorNotFoundException exception) {
		HmsErrorResponse error = new HmsErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<HmsErrorResponse> handleException(Exception exception) {
		HmsErrorResponse error = new HmsErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Bad Request");
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
    
	//post method(insert)
	@PostMapping("/doctor")
	public Doctor addDoctor(  @RequestBody Doctor doctor) {
		return doctService.save(doctor);
	}
    
	//get method(findbyId)
	@GetMapping("/doctors/{id}")
	public Doctor findByDoctId(@PathVariable("id") int doctorId) {
		if (doctService.findByDoctId(doctorId) == null) {
			throw new DoctorNotFoundException("Doctor not found with this doctor id");
		}
		return doctService.findByDoctId(doctorId);
	}
    
	//delete method(byId)
	@DeleteMapping("/doctors/{id}")
	public String deleteByDoctorid(@PathVariable("id") int doctorId) {
		if (doctService.deleteByDoctorid(doctorId) == null) {
			throw new DoctorNotFoundException("Doctor not found with this doctor id");
		}
		return doctService.deleteByDoctorid(doctorId);
	}
    
	//put method(update)
	@PutMapping("/doctors")
	public Doctor update(  @RequestBody Doctor doctor) {
		return doctService.update(doctor);
	}
    
	//get method(alldoctors)
	@GetMapping("/doctors/alldoctors")
	public List<Doctor> getAllDoctors() {
		return doctService.findAll();
	}

}
