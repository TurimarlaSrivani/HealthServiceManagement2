package com.hsm.healthservicemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Doctor;
import com.hsm.healthservicemanagement.repository.IDocterRepository;
import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService{
	
	@Autowired
	IDocterRepository doctRepo;
	
	@Override
	public Doctor save(Doctor doctor) {
		return doctRepo.save(doctor);
	}
	
	@Override
	public Doctor findByDoctId(int id) {
		java.util.Optional<Doctor> opt = doctRepo.findById(id);
		if(!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}
	
	@Override
	public String deleteByDoctorid(int id) {
		java.util.Optional<Doctor> doct = doctRepo.findById(id);
		if(!doct.isPresent()) {
			return null;
		}
		doctRepo.deleteById(id);
		return "doctor with id " +id+ " is deleted";
	}
	
	
	@Override
	public Doctor update(Doctor doctor) {
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

	@Override
	public List<Doctor> findAll() {
		return  doctRepo.findAll();
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
