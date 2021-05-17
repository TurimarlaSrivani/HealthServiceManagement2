package com.hsm.healthservicemanagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsm.healthservicemanagement.entity.Treatment;
import com.hsm.healthservicemanagement.entity.TreatmentStatus;

// Spring Data JPA

@Repository
public interface ITreatmentRepository extends JpaRepository<Treatment, Integer > {

	Treatment findByTreatmentId(int treatmentId);

	List<Treatment> findByTreatmentDate(LocalDate treatmentDate);

	List<Treatment> findByTreatmentStatus(TreatmentStatus treatmentStatus);

	}
