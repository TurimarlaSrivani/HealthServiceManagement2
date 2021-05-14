package com.hsm.healthservicemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hsm.healthservicemanagement.entity.Disease;

	// Spring Data JPA
@Repository
public interface IDiseaseRepository extends JpaRepository<Disease, Integer > {

	

	// Custom methods
	// find by name
	Disease findByDesName(String name);
	
	// Search PatientDisease based on Disease
	//List<Disease> findAllDesByDes(String desName);
	
	// find pat's who's id is less than 150
	List<Disease> findByDesIdLessThan(int id);
	
	// Find PatientDisease based on des and display in asc order
	//List<Disease> findByDesNameByDesNameDesc(String desName);



	           
}


