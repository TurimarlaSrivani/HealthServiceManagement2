package com.hsm.healthservicemanagement.controller;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.Doctor;
import com.hsm.healthservicemanagement.exception.DoctorNotFoundException;
import com.hsm.healthservicemanagement.service.IDoctorService;

import java.util.List;

@CrossOrigin
@RestController
public class DoctorController {

	// Logger Declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(DoctorController.class);

	// We are autowiring the diet service layer to this controller layer of doctor
	@Autowired
	IDoctorService doctService;

	// This controller is used to create a new or add new doctor and redirects it
	// to the service layer.
	// save diet

	// post method(insert)
	@PostMapping("/doctors")
	public Doctor addDoctor(@RequestBody Doctor doctor) {

		// setting logger info
		logger.info("save the details of the doctor");

		return doctService.save(doctor);
	}

	// This controller is used to get a specific doctor on basis of ID.
	// viewByDoctorId

	// get method(findbyId)
	@GetMapping("/doctors/{doctorId}")
	public Doctor findByDoctId(@PathVariable("doctorId") int doctorId) {

		// setting logger info
		logger.info("Get the doctor details By Id");

		if (doctService.findByDoctId(doctorId) == null) {
			throw new DoctorNotFoundException("Doctor not found with this doctor id");
		}
		return doctService.findByDoctId(doctorId);
	}

	// This controller function perform deletion of a specific given doctor
	// and request the service to perform the action and return the message as
	// deleted else throw exception.
	// deleteDoctorByDoctorId

	// delete method(byId)
	@DeleteMapping("/doctors/{doctorId}")
	public String deleteByDoctorid(@PathVariable("doctorId") int doctorId) {

		// setting logger info
		logger.info(" delete the delete Doctor By Id");

		if (doctService.deleteByDoctorid(doctorId) == null) {
			throw new DoctorNotFoundException("Doctor not found with this doctor id");
		}
		return doctService.deleteByDoctorid(doctorId);
	}

	// This function is used to update a specific doctor on basis of given
	// doctor id and returns exception if given doctor id is not found.
	// updateDoctor

	// put method(update)
	@PutMapping("/doctors/{doctorId}")
	public ResponseEntity<Doctor> update(@PathVariable("doctorId") int doctorId, @RequestBody Doctor doctor) throws DoctorNotFoundException {

		// setting logger info
		logger.info("update the doctor details by id");

		Doctor doct = doctService.update(doctor);
		if (doct == null) {
			throw new DoctorNotFoundException("Doctor not found with this doctor id: " + doctorId);
		}
		return new ResponseEntity<>(doct, HttpStatus.OK);
	}

	// This controller is used to return and list all the doctor found in the
	// database and request to the service to perform the action.
	// viewAllDoctorDetails

	// get method(alldoctors)
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctors() {

		// setting logger info
		logger.info("Find the details of the doctor");

		return doctService.findAll();
	}

	@GetMapping("/doctors/{doctorname}")
	public Doctor findByDoctorName(@PathVariable("doctorname") String doctorName) {
		// setting logger info
		logger.info("Find the details of the doctor");
		return (doctService.findByDoctorName(doctorName));
		// return new ResponseEntity<>(financeService.findByPatientName(patientName)),
		// HttpStatus.OK);
	}

}
