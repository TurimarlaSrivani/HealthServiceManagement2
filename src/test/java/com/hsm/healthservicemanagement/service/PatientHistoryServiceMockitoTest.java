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
	
	//getAllPatentHistory
		@Test
		void testGetAllPatientHistory() {
			 PatientHistory his1=new PatientHistory(123,LocalDate.parse("2013-09-13"));
			 PatientHistory his2=new PatientHistory(345,LocalDate.parse("2016-11-27"));
			 PatientHistory his3=new PatientHistory(456,LocalDate.parse("2020-03-18"));
			 
			 List<PatientHistory> list=new ArrayList<PatientHistory>();
			 list.add(his1);
			 list.add(his2);
			 list.add(his3);
			 
			 Mockito.when(rep.findAll()).thenReturn(list);
			 List<PatientHistory> his=history.getAllPatientHistory();
			 assertEquals(3, his.size());
		}
		
		//AddPatientHistory
		@Test
		void testAddPatientHistory() {
			 PatientHistory his=new PatientHistory(567,LocalDate.parse("2013-09-23"));
			 
			 Mockito.when(rep.save(his)).thenReturn(his);
			 
			 PatientHistory persistedHis=history.addPatientHistory(his);
			 assertEquals(567, persistedHis.getPatientHistoryId());
			 assertEquals(LocalDate.parse("2013-09-23"),persistedHis.getRecordedDate());
		}
		
		//FindByPatientHistoryId
		@Test
		void testFindByPatientHistoryId() {
			 PatientHistory his=new PatientHistory(123,LocalDate.parse("2013-09-13"));
			 
			 Mockito.when(rep.findById(123)).thenReturn(Optional.of(his));
			 
			 PatientHistory persistedHis=history.findByPatientHistoryId(123);
			 assertEquals(123, persistedHis.getPatientHistoryId());
			 assertEquals(LocalDate.parse("2013-09-13"),persistedHis.getRecordedDate());
		}
		
		//UpdatePatientHistory
		@Test
		void testUpdatePatientHistory() {
			 PatientHistory his=new PatientHistory(567,LocalDate.parse("2013-09-23"));
			 
			 Mockito.when(rep.findById(567)).thenReturn(Optional.of(his));
			 Mockito.when(rep.save(his)).thenReturn(his);
			 
			 PatientHistory persistedHis=history.updatePatientHistory(his);
			 assertEquals(567, persistedHis.getPatientHistoryId());
			 assertEquals(LocalDate.parse("2013-09-23"),persistedHis.getRecordedDate());
		}
		
		//DeletePatientHistory
		@Test
		void testDeletePatientHistoryId() {
			 PatientHistory his=new PatientHistory(123,LocalDate.parse("2013-09-13"));
			 
			 Mockito.when(rep.findById(123)).thenReturn(Optional.of(his));
			 rep.deleteById(123);
			 
			 String persistedHis=history.deleteByPatientHistoryId(123);
			 assertEquals(123, Integer.parseInt(persistedHis.trim()));
		}
}