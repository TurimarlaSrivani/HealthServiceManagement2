package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.PatientCase;
import com.hsm.healthservicemanagement.repository.IPatientCaseRepository;
@Service
public class PatientCaseServiceImpl implements IPatientCaseService {
	
		@Autowired
		IPatientCaseRepository patientRepository;

		@Override
		public PatientCase save(PatientCase PatientCase) {
			
			return patientRepository.save(PatientCase);
		}

		@Override
		public PatientCase deletePatientCase(int Id) {
			Optional<PatientCase> opt =patientRepository.findById(Id);
			if(!opt.isPresent())
			{
				return null;
			}
			PatientCase pc =opt.get();
			patientRepository.deleteById(Id);
			return pc;
		}

		@Override
		public List<PatientCase> viewAll() {
			
			return patientRepository.findAll();
		}

		@Override
		public PatientCase viewPatientCaseById(int Id) {
			Optional<PatientCase> opt = patientRepository.findById(Id);
			if(!opt.isPresent())
			{
				return null;
			}
			
			return opt.get();
		}

		@Override
		public PatientCase update(PatientCase PatientCase) {
			Optional<PatientCase> opt = patientRepository.findById(PatientCase.getPatientCaseId());
			if(!opt.isPresent())
			{
				return null;
			}
			
			PatientCase pc =opt.get();
			pc.setAssociateDoctorName(PatientCase.getAssociateDoctorName());
			pc.setMedicineFee(PatientCase.getMedicineFee());
			pc.setAppointmentDate(PatientCase.getAppointmentDate());
			pc.setCurrentTreatment(PatientCase.getCurrentTreatment());
			
			pc.setPatientCaseId(PatientCase.getPatientCaseId());
			pc.setPatientId(PatientCase.getPatientId());
			pc.setMedicines(PatientCase.getMedicines());
			return patientRepository.save(pc);
		}

		@Override
		public PatientCase updateById(int Id, PatientCase PatientCase) {
			Optional<PatientCase> opt = patientRepository.findById(Id);
			if(!opt.isPresent())
			{
				return null;
			}
			PatientCase pc=opt.get();
			pc.setMedicines(PatientCase.getMedicines());
			return patientRepository.save(pc);
		}
}		
		

		
		