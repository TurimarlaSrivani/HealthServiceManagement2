package com.hsm.healthservicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsm.healthservicemanagement.entity.PatientHistory;

@Repository
public interface IPatientHistoryRepository extends JpaRepository<PatientHistory,Integer>{
	
	

}
