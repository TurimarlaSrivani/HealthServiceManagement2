package com.hsm.healthservicemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hsm.healthservicemanagement.entity.Disease;

// Spring Data JPA
@Repository
public interface IDiseaseRepository extends JpaRepository<Disease, Integer> {

	// Custom methods
	// find by name
	Disease findByDiseaseName(String name);

	List<Disease> findByDiseaseIdLessThan(int id);

	// Find Disease based on des and display in asc order
	// List<Disease> findByDiseaseNameByDiseaseNameDesc(String desName);

}