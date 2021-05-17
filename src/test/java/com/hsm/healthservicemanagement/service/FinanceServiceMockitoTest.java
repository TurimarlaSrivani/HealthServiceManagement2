package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.hsm.healthservicemanagement.entity.Finance;
import com.hsm.healthservicemanagement.repository.IFinanceRepository;

@ExtendWith(SpringExtension.class)
public class FinanceServiceMockitoTest {

	
	@InjectMocks
	FinanceServiceImpl financeService;

	@MockBean
	IFinanceRepository financeRepo;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	// findAllFinanceDetails
	@Test
	void testFindAllFinanceDetails() {
		Finance f1 = new Finance(101, 40, "Radhe", 20, 30, 90, 1);
		Finance f2 = new Finance(102, 40, "Abhinaya", 50, 50, 140, 2);
		Finance f3 = new Finance(103, 20, "Sagar", 40, 20, 90, 3);
		Finance f4 = new Finance(104, 30, "Vidhya", 10, 60, 100, 4);
		Finance f5 = new Finance(105, 30, "Anny", 50, 50, 130, 5);
		Finance f6 = new Finance(106, 10, "Reeti", 20, 50, 80, 6);
		
		List<Finance> financeList = new ArrayList<>();
		financeList.add(f1);
		financeList.add(f2);
		financeList.add(f3);
		financeList.add(f4);
		financeList.add(f5);
		financeList.add(f6);
		Mockito.when(financeRepo.findAll()).thenReturn(financeList);
		List<Finance> fin = financeService.findAllFinanceDetails();
		assertEquals(6, fin.size());
	}

	
	// save
	@Test
	void testSave() {
		Finance fin = new Finance(107, 40, "Vinay", 100, 10, 150, 7);
		Mockito.when(financeRepo.save(fin)).thenReturn(fin);

		Finance persistedFin = financeService.save(fin);

		assertEquals(107, persistedFin.getPatientId());
		assertEquals("Vinay", persistedFin.getPatientName());
		assertEquals(40, persistedFin.getRegistrationFee());
		assertEquals(100, persistedFin.getDoctorFee());
		assertEquals(10, persistedFin.getMedicinesAmount());
		assertEquals(150, persistedFin.getTotalFee());
		assertEquals(7, persistedFin.getFinanceId());
	}


	// findByPatientId
	@Test
	void testFindByPatientId() {
		Finance fin = new Finance(102, 40, "Abhinaya", 50, 50, 140, 2);

		Mockito.when(financeRepo.findById(2)).thenReturn(Optional.of(fin));
		Finance persistedFin = financeService.findByPatientId(2);

		assertEquals(102, persistedFin.getPatientId());
		assertEquals("Abhinaya", persistedFin.getPatientName());
		assertEquals(40, persistedFin.getRegistrationFee());
		assertEquals(50, persistedFin.getDoctorFee());
		assertEquals(50, persistedFin.getMedicinesAmount());
		assertEquals(140, persistedFin.getTotalFee());
		assertEquals(2, persistedFin.getFinanceId());
	}

	// deleteFinanceByPatientId
	@Test
	void testDeleteFinanceByPatientId() {
		Finance fin = new Finance(107, 40, "Vinay", 100, 10, 150, 7);

		Mockito.when(financeRepo.findById(107)).thenReturn(Optional.of(fin));
		financeRepo.deleteById(107);

		Finance persistedFin = financeService.deleteFinanceByPatientId(107);

		assertEquals(107, persistedFin.getPatientId());
		assertEquals("Vinay", persistedFin.getPatientName());
		assertEquals(40, persistedFin.getRegistrationFee());
		assertEquals(100, persistedFin.getDoctorFee());
		assertEquals(10, persistedFin.getMedicinesAmount());
		assertEquals(150, persistedFin.getTotalFee());
		assertEquals(7, persistedFin.getFinanceId());
	}

	// update
	@Test
	void testUpdateFinance() {
		Finance fin = new Finance(102, 40, "Abhi", 60, 20, 120, 2);

		Mockito.when(financeRepo.findById(2)).thenReturn(Optional.of(fin));
		Mockito.when(financeRepo.save(fin)).thenReturn(fin);

		Finance persistedFin = financeService.updateFinance(fin);

		assertEquals(102, persistedFin.getPatientId());
		assertEquals("Abhi", persistedFin.getPatientName());
		assertEquals(40, persistedFin.getRegistrationFee());
		assertEquals(60, persistedFin.getDoctorFee());
		assertEquals(20, persistedFin.getMedicinesAmount());
		assertEquals(120, persistedFin.getTotalFee());
		assertEquals(2, persistedFin.getFinanceId());
	}

}