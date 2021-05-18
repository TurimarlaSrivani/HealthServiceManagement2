package com.hsm.healthservicemanagement.service;

import com.hsm.healthservicemanagement.entity.Doctor;

import java.util.List;

public interface IDoctorService {
	
	Doctor save(Doctor doctor);
	String deleteByDoctorid(int doctorId);
	Doctor update(Doctor doctor);
	List<Doctor> findAll();
	Doctor findByDoctId(int id);
	
	//custom methods
	Doctor findByDoctorName(String doctorName);
	Doctor findByspecialization(String specialization);
	Doctor delete(Doctor doctor);
	Doctor findByContactNumber(String contactNumber);

}
