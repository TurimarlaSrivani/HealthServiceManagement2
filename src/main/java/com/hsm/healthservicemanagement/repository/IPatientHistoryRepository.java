package com.hsm.healthservicemanagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsm.healthservicemanagement.entity.PatientHistory;

@Repository
public interface IPatientHistoryRepository extends JpaRepository<PatientHistory,Integer>{
	
	
	//findByRecordedDate
	List<PatientHistory> findByRecordedDate(LocalDate recordedDate);
	
	

}