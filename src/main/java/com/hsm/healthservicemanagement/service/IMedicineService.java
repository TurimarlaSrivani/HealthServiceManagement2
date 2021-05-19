package com.hsm.healthservicemanagement.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Medicine;


@Service
public interface IMedicineService {
	public Medicine viewMedicine(int medicineId);

	public List<Medicine> showAllMedicine();

	public Medicine addMedicine(Medicine medicine);

	public Medicine deleteMedicine(int medicineId);

	public Medicine updateMedicine(Medicine medicine);


	public Medicine updateMedicineName(int medicineId, Medicine medicine);

	// custom methods
	// find by name
	public Medicine findByMedicineName(String medicineName);

}
