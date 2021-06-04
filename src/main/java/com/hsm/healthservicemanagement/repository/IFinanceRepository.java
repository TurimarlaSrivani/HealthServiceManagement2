package com.hsm.healthservicemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hsm.healthservicemanagement.entity.Finance;

@Repository
public interface IFinanceRepository extends JpaRepository<Finance, Integer> {

	// Custom Methods
		// find based on patient name and display
		List<Finance> findByPatientName(String patientName);
}