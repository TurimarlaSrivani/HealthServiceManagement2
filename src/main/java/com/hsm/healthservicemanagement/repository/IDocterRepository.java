package com.hsm.healthservicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hsm.healthservicemanagement.entity.Doctor;

@Repository
public interface IDocterRepository extends JpaRepository<Doctor, Integer > {
	
	//find by docter id
	Doctor findByDoctorId(int doctorId);
	
	//find by docter name
	Doctor findByDoctorName(String doctorName);
	
	//find by docter specialization
	Doctor findByspecialization(String specialization);
	
	//find by docter contactNumber
	Doctor findByContactNumber(String contactNumber);



}
