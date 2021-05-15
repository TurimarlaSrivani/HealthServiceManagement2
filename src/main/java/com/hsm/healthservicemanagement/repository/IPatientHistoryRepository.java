package com.hsm.healthservicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hsm.healthservicemanagement.entity.PatientHistory;

public interface IPatientHistoryRepository extends JpaRepository<PatientHistory,Integer>{
	
	/*PatientHistory findByPatientId(int patientId);
	
	//PatientHistory deleteByPatientId(int patientId);
	
	@Query("select e from PatientHistory e where e.patientId=:i")
	public PatientHistory getByPatientId(@Param("i") int patientId);
	
	/*@Query("delete p from PatientHistory p where p.patientId=:n")
	public PatientHistory deleteByPatientId1(@Param("n") int patientId);*/
	
	
	
	

}
