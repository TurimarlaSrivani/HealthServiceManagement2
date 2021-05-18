package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.PatientHistory;

@SpringBootTest
class PatientHistoryServiceTest {

	
	@Autowired
	IPatientHistoryService history;
	
	//AddPatientHistory
	@Test
	@Order(1)
	void testAddPatientHistory() {
		 PatientHistory his=new PatientHistory(567,LocalDate.parse("2020-09-23"));
		 PatientHistory persistedHis=history.addPatientHistory(his);
		 assertEquals(567, persistedHis.getPatientHistoryId());
		 assertEquals(LocalDate.parse("2020-09-23"),persistedHis.getRecordedDate());
	}
	
	//getAllPatientHistory
	@Order(2)
	@Test
	void testGetAllPatientHistory() {
		 
		List<PatientHistory> his=history.getAllPatientHistory();
		assertEquals(4,his.size());	
	}
	
	//findByPatientHistoryId
	@Order(3)
	@Test
	void testFindByPatientHistoryId() {
		 
		PatientHistory his=history.findByPatientHistoryId(123);
		assertEquals(LocalDate.parse("2013-09-23"),his.getRecordedDate());
		
	}
	
	//UpdatePatientHistory
	@Order(4)
	@Test
	void testUpdatePatientHistory() {
	PatientHistory his = new PatientHistory();
	his.setPatientHistoryId(123);
	his.setRecordedDate(LocalDate.parse("2013-09-23"));
	PatientHistory phis=history.updatePatientHistory(his);
	assertEquals(123, phis.getPatientHistoryId());
	
	}
	
	//DeletePatientHistory
	@Order(5)
	@Test
	void testDeleteByPatientHistory() {
		 String his=history.deleteByPatientHistoryId(567);
		 assertEquals(567,Integer.parseInt(his.trim()));
	}
}