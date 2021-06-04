package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.PatientHistory;

@SpringBootTest
class PatientHistoryServiceTest {

	// Logger Declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PatientHistoryServiceTest.class);

	@Autowired
	IPatientHistoryService service;

	// Testing whether the patient history gets added to the database
	@Test
	@Order(1)
	void testAddPatientHistory() {
		PatientHistory his = new PatientHistory(567, LocalDate.parse("2020-09-23"));
		PatientHistory persistedHis = service.addPatientHistory(his);
		assertEquals(567, persistedHis.getPatientHistoryId());
		assertEquals(LocalDate.parse("2020-09-23"), persistedHis.getRecordedDate());
		logger.info("Logger save to Patient History");
	}

	// Testing whether patient history database has patient history or null
	@Order(2)
	@Test
	void testGetAllPatientHistory() {

		List<PatientHistory> history = service.getAllPatientHistory();
		assertEquals(4, history.size());
		for (PatientHistory phistory : history) {
			logger.info(phistory);
			logger.info("logger added to getAllPatientHistory");
		}
	}

	// Testing whether the given id fetches the patient history details from the
	// database
	@Order(3)
	@Test
	void testFindByPatientHistoryId() {

		PatientHistory his = service.findByPatientHistoryId(123);
		assertEquals(LocalDate.parse("2013-09-23"), his.getRecordedDate());
		logger.info("logger view patient history by findByPatientHistoryId ");

	}

	// Testing whether the patient history detail gets updated to the database
	@Order(4)
	@Test
	void testUpdatePatientHistory() {
		PatientHistory history = new PatientHistory();
		history.setPatientHistoryId(123);
		history.setRecordedDate(LocalDate.parse("2013-09-23"));
		PatientHistory phistory = service.updatePatientHistory(history);
		assertEquals(123, phistory.getPatientHistoryId());
		logger.info("logger save to Patient History");

	}

	// Testing whether the patient history detail gets removed from the database
	@Order(5)
	@Test
	void testDeleteByPatientHistory() {
		String his = service.deleteByPatientHistoryId(567);
		assertEquals(567, Integer.parseInt(his.trim()));
		logger.info("Deleted succesfully");
	}
}