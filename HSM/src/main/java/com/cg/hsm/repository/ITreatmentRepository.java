package com.cg.hsm.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hsm.entity.Treatment;
import com.cg.hsm.entity.TreatmentStatus;

// Spring Data JPA

@Repository
public interface ITreatmentRepository extends JpaRepository<Treatment, Integer > {

	Treatment findByTreatmentId(int treatmentId);

	Treatment findByPatientCaseId(int patientCaseId);

	List<Treatment> findByTreatmentDate(LocalDate treatmentDate);

	List<Treatment> findByTreatmentStatus(TreatmentStatus treatmentStatus);

	}
