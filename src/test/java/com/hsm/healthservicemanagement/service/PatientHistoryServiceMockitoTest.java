package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hsm.healthservicemanagement.entity.PatientHistory;
import com.hsm.healthservicemanagement.repository.IPatientHistoryRepository;

@ExtendWith(SpringExtension.class)
class PatientHistoryServiceMockitoTest {

	
	@InjectMocks
	PatientHistoryServiceImpl history;
	
	@MockBean
	IPatientHistoryRepository rep;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testAddPatientHistory() {
		 PatientHistory his=new PatientHistory(4,104,LocalDate.parse("2013-09-23"));
		 
		 Mockito.when(rep.save(his)).thenReturn(his);
		 
		 PatientHistory persistedHis=history.addPatientHistory(his);
		 assertEquals(104, persistedHis.getPatientHistoryId());
		 assertEquals(4, persistedHis.getPatientId());
		 assertEquals(LocalDate.parse("2013-09-23"),persistedHis.getRecordedDate());
	}
	
	@Test
	void testFindByPatientHistoryId() {
		 PatientHistory his=new PatientHistory(5,105,LocalDate.parse("2013-09-23"));
		 
		 Mockito.when(rep.findById(105)).thenReturn(Optional.of(his));
		 
		 PatientHistory persistedHis=history.findByPatientHistoryId(105);
		 assertEquals(105, persistedHis.getPatientHistoryId());
		 assertEquals(5, persistedHis.getPatientId());
		 assertEquals(LocalDate.parse("2013-09-23"),persistedHis.getRecordedDate());
	}
	
	/*@Test
	void testFindByPatientId() {
		PatientHistory his=new PatientHistory(102,2,LocalDate.parse("2012-05-27"));
		 
		 Mockito.when(rep.findByPatientId(2)).thenReturn(his);
		 
		 PatientHistory persistedHis=history.findByPatientId(2);
		 assertEquals(102, persistedHis.getPatientHistoryId());
		 assertEquals(2, persistedHis.getPatientId());
		 assertEquals(LocalDate.parse("2012-05-27"),persistedHis.getRecordedDate());
	}*/
	
	@Test
	void testGetAllPatientHistory() {
		 PatientHistory his1=new PatientHistory(5,101,LocalDate.parse("2013-09-23"));
		 PatientHistory his2=new PatientHistory(6,102,LocalDate.parse("2012-05-27"));
		 PatientHistory his3=new PatientHistory(7,103,LocalDate.parse("2013-06-13"));
		 
		 List<PatientHistory> list=new ArrayList<PatientHistory>();
		 list.add(his1);
		 list.add(his2);
		 list.add(his3);
		 
		 Mockito.when(rep.findAll()).thenReturn(list);
		 List<PatientHistory> his=history.getAllPatientHistory();
		 assertEquals(3, his.size());
	}
	
	@Test
	void testUpdatePatientHistory() {
		 PatientHistory his=new PatientHistory(4,104,LocalDate.parse("2013-09-23"));
		 
		 Mockito.when(rep.findById(104)).thenReturn(Optional.of(his));
		 Mockito.when(rep.save(his)).thenReturn(his);
		 
		 PatientHistory persistedHis=history.updatePatientHistory(his);
		 assertEquals(104, persistedHis.getPatientHistoryId());
		 assertEquals(4, persistedHis.getPatientId());
		 assertEquals(LocalDate.parse("2013-09-23"),persistedHis.getRecordedDate());
	}
	
	@Test
	void testDeletePatientHistoryId() {
		 PatientHistory his=new PatientHistory(3,104,LocalDate.parse("2013-09-23"));
		 
		 Mockito.when(rep.findById(104)).thenReturn(Optional.of(his));
		 rep.deleteById(104);
		 
		 String persistedHis=history.deleteByPatientHistoryId(104);
		 assertEquals(104, Integer.parseInt(persistedHis.trim()));
	}
}
	
