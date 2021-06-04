package com.hsm.healthservicemanagement.service;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Doctor;
import com.hsm.healthservicemanagement.repository.IDocterRepository;
import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService { // Implementation of service layer method by extend that
															// method

	@Autowired
	IDocterRepository doctRepo;
	// Bean Object of service class

	// Used to store the given doctor Object passes from the controller
	// save doctor
	
	 //Logger declare
	  org.apache.logging.log4j.Logger logger = LogManager.getLogger(DoctorServiceImpl.class);
	  
	@Override
	public Doctor save(Doctor doctor) {
		
		// setting logger info
				logger.info("save the details of the doctor");
		return doctRepo.save(doctor);
	}

	// Get a specific doctor of the given ID
	// viewDoctorById
	@Override
	public Doctor findByDoctId(int id) {
		// setting logger info
				logger.info("Get the doctor details By Id");
				
		java.util.Optional<Doctor> opt = doctRepo.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

	// Used to delete the doctor by id
	// deleteByDoctorId
	@Override
	public String deleteByDoctorid(int id) {
		
		// setting logger info
		logger.info(" delete the doctor By Id");
		java.util.Optional<Doctor> doct = doctRepo.findById(id);
		if (!doct.isPresent()) {
			return null;
		}
		doctRepo.deleteById(id);
		return "doctor with id " + id + " is deleted";
	}

	// Used to update the doctor type of given id and object
	// updateDoctorDetails
	@Override
	public Doctor update(Doctor doctor) {
		
		// setting logger info
				logger.info("update the specific property by id");

		
		Doctor doc = doctRepo.findById(doctor.getDoctorId()).get();
		doc.setDoctorName(doctor.getDoctorName());
		doc.setContactNumber(doctor.getContactNumber());
		doc.setYearsOfExperience(doctor.getYearsOfExperience());
		doc.setDegree(doctor.getDegree());
		doc.setSpecialization(doctor.getSpecialization());
		doc.setDoctorName(doctor.getDoctorName());
		doc.setDoctorFee(doctor.getDoctorFee());
		doc.setHoursOfAvailability(doctor.getHoursOfAvailability());
		return doctRepo.save(doc);
	}

	// Used to list all the doctor from the database
	// viewAllDoctorDetails
	@Override
	public List<Doctor> findAll() {
		
		// setting logger info
				logger.info("Find the details of the doctor");
		return doctRepo.findAll();
	}

	@Override
	public Doctor findByspecialization(String specialization) {
		return doctRepo.findByspecialization(specialization);
	}

	@Override
	public Doctor delete(Doctor doctor) {
		doctRepo.delete(doctor);
		return doctor;
	}

	@Override
	public Doctor findByContactNumber(String contactNumber) {
		return doctRepo.findByContactNumber(contactNumber);
	}

	@Override
	public Doctor findByDoctorName(String doctorName) {
		return doctRepo.findByDoctorName(doctorName);
	}

}
