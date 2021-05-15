package com.hsm.healthservicemanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsm.healthservicemanagement.entity.PatientCase;

@Repository
public interface IPatientCaseRepository extends JpaRepository <PatientCase, Integer> {

}
