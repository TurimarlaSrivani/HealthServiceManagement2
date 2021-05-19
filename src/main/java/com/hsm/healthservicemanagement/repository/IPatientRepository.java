package com.hsm.healthservicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hsm.healthservicemanagement.entity.Patient;


@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer>{
	
	//Custom methods
	// find by name
		Patient findByPatientName(String name);
		
   
}