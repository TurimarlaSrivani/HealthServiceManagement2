package com.hsm.healthservicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hsm.healthservicemanagement.entity.Finance;

@Repository
public interface IFinanceRepository extends JpaRepository<Finance, Integer> {

	// custom queries //atQuery
	Finance findByPatientName(String paitientName);

}