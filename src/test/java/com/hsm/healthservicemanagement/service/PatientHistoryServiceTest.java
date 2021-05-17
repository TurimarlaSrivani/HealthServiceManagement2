package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.PatientHistory;

@SpringBootTest
class PatientHistoryServiceTest {

	@Autowired
	IPatientHistoryService history;
	
	@Test
	void testGetAllPatientHistory() {
		 
		List<PatientHistory> his=history.getAllPatientHistory();
		assertEquals(4,his.size());	
	}
	
	@Test
	void testFindByPatientHistoryId() {
		 
		PatientHistory his=history.findByPatientHistoryId(102);
		//assertEquals(2,his.getPatientId());
		assertEquals(LocalDate.parse("2021-05-14"),his.getRecordedDate());
		
	}
	
	/*@Test
	void testFindByPatientId() {
		 
		PatientHistory his=history.findByPatientId(2);
		assertEquals(102,his.getPatientHistoryId());
		assertEquals(LocalDate.parse("2021-05-13"),his.getRecordedDate());
		
	}*/
	
	@Test
	void testAddPatientHistory() {
		 PatientHistory his=new PatientHistory(103,LocalDate.parse("2013-09-23"));
		 PatientHistory persistedHis=history.addPatientHistory(his);
		 assertEquals(103, persistedHis.getPatientHistoryId());
		 //assertEquals(3, persistedHis.getPatientId());
		 assertEquals(LocalDate.parse("2013-09-23"),persistedHis.getRecordedDate());
	}
	
	@Test
	void testUpdatePatientHistory() {
		 PatientHistory his=new PatientHistory(103,LocalDate.parse("2013-09-23"));
		 PatientHistory persistedHis=history.updatePatientHistory(his);
		 assertEquals(103, persistedHis.getPatientHistoryId());
		 //assertEquals(3, persistedHis.getPatientId());
		 assertEquals(LocalDate.parse("2013-09-23"),persistedHis.getRecordedDate());
	}
	
	@Test
	void testDeleteByPatientHistory() {
		 String his=history.deleteByPatientHistoryId(103);
		 assertEquals(103,Integer.parseInt(his.trim()));
		 //assertEquals(LocalDate.parse("2013-09-23"),his.getRecordedDate());
	}

}
