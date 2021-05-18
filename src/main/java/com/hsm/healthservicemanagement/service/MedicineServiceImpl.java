package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Medicine;
import com.hsm.healthservicemanagement.repository.IMedicineRepository;

@Service
public class MedicineServiceImpl implements IMedicineService {
	@Autowired
	IMedicineRepository medRepo;

	@Override
	public Medicine viewMedicine(int medicineId) {
		Optional<Medicine> opt = medRepo.findById(medicineId);
		if (!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

	@Override
	public List<Medicine> showAllMedicine() {
		return medRepo.findAll();
	}

	@Override
	public Medicine addMedicine(Medicine medicine) {
		return medRepo.save(medicine);
	}

	@Override
	public Medicine deleteMedicine(int medicineId) {
		Optional<Medicine> opt = medRepo.findById(medicineId);
		if (!opt.isPresent()) {
			return null;
		}
		Medicine med = opt.get();
		medRepo.deleteById(medicineId);
		return med;
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) {
		Optional<Medicine> opt = medRepo.findById(medicine.getMedicineId());
		if (!opt.isPresent()) {
			return null;
		}
		Medicine med = opt.get();
		med.setMedicineName(medicine.getMedicineName());
		med.setMedicineCost(medicine.getMedicineCost());
		med.setMfd(medicine.getMfd());
		med.setExpiryDate(medicine.getExpiryDate());
		return medRepo.save(med);
	}

	@Override
	public Medicine updateMedicineName(int medicineId, Medicine medicine) {
		Optional<Medicine> opt = medRepo.findById(medicineId);
		if (!opt.isPresent()) {
			return null;
		}
		Medicine med = opt.get();
		med.setMedicineName(medicine.getMedicineName());

		return medRepo.save(med);
	}

	@Override
	public Medicine findByMedicineName(String medicineName) {
		return medRepo.findByMedicineName(medicineName);
	}

}