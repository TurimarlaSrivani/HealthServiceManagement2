package com.hsm.healthservicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hsm.healthservicemanagement.entity.PatientHistory;

public interface IPatientHistoryRepository extends JpaRepository<PatientHistory,Integer>{
	
	

}
