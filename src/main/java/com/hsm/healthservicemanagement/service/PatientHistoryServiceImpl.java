package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.PatientHistory;
import com.hsm.healthservicemanagement.repository.IPatientHistoryRepository;

@Service
public class PatientHistoryServiceImpl implements IPatientHistoryService {

	@Autowired
	IPatientHistoryRepository rep;
	
	@Override
	public PatientHistory addPatientHistory(PatientHistory his) {
		return rep.save(his);
	}

	/*@Override
	public PatientHistory findByPatientId(int patientId) {
		Optional<PatientHistory> his=Optional.of(rep.findByPatientId(patientId));
		if(!his.isPresent())
		{
			return null;
		}
		return rep.findByPatientId(patientId);
	}*/

	@Override
	public PatientHistory findByPatientHistoryId(int patientHistoryId) {
		Optional<PatientHistory> his=rep.findById(patientHistoryId);
		if(!his.isPresent())
		{
			return null;
		}
		return his.get();
	}

	@Override
	public String deleteByPatientHistoryId(int patientHistoryId) {
		Optional<PatientHistory> his=rep.findById(patientHistoryId);
		if(!his.isPresent())
		{
			return null;
		}
		//PatientHistory p=his.get();
		rep.deleteById(patientHistoryId);
		System.out.print("Successfully deleted :"+patientHistoryId);
		return patientHistoryId+"";
		
		
	}

	@Override
	public PatientHistory updatePatientHistory(PatientHistory his) {
		Optional<PatientHistory> history=rep.findById(his.getPatientHistoryId());
		if(!history.isPresent())
		{
			return null;
		}
		PatientHistory p=history.get();
		//p.setPatientId(his.getPatientId());
		p.setRecordedDate(his.getRecordedDate());
		return rep.save(p);
	}

	@Override
	public List<PatientHistory> getAllPatientHistory() {
		return rep.findAll();
	}
	
	@Override
		public PatientHistory findByPatientId(int patientId) {
			Optional<PatientHistory> his=rep.findById(patientId);
			if(!his.isPresent())
			{
				return null;
			}
			return his.get();
		}

}
