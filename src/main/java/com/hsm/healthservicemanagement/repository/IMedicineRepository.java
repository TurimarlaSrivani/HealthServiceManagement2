package com.hsm.healthservicemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsm.healthservicemanagement.entity.Medicine;


@Repository
public interface IMedicineRepository extends JpaRepository<Medicine, Integer> {

	// Custom methods
	Medicine findByMedicineName(String medicineName);

	List<Medicine> findByMedicineIdLessThan(int medicineId);

}

