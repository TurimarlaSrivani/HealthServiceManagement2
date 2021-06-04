package com.hsm.healthservicemanagement.service;

import com.hsm.healthservicemanagement.entity.Doctor;

import java.util.List;

public interface IDoctorService {

	// Method to be override by the implementing class
	// save doctor
	Doctor save(Doctor doctor);

	// Method to be override by the implementing class
	// deleteDoctorByDoctorId
	String deleteByDoctorid(int doctorId);

	// Method to be override by the implementing class
	// update
	Doctor update(Doctor doctor);

	// Method to be override by the implementing class
	// viewAllDoctorDetails
	List<Doctor> findAll();

	// Method to be override by the implementing class
	// findDoctorByDoctorId
	Doctor findByDoctId(int id);

	// custom methods
	Doctor findByDoctorName(String doctorName);

	Doctor findByspecialization(String specialization);

	Doctor delete(Doctor doctor);

	Doctor findByContactNumber(String contactNumber);

}
