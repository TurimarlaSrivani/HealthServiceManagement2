package com.hsm.healthservicemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.PatientCase;

@Service
public interface IPatientCaseService {
	
		PatientCase save(PatientCase PatientCase);
		public PatientCase deletePatientCase(int id);
		public List<PatientCase>viewAll();
		public PatientCase viewPatientCaseById(int Id);
		public PatientCase update(PatientCase PatientCase);
		public PatientCase updateById(int Id,PatientCase PatientCase);
		
		
}
