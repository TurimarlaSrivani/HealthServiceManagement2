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
		Finance f1 = new Finance(1,"Sam",20,30,500,550);
		Finance f2 = new Finance(2,"Gagana",60,20,600,680);
		Finance f3 = new Finance(3,"Krithi",60,20,400,480);
		Finance f4 = new Finance(4,"Deepa",60,20,500,580);
		Finance f5 = new Finance(5,"Roopa",60,20,600,680);
		
		List<Finance> financeList = new ArrayList<>();
		financeList.add(f1);
		financeList.add(f2);
		financeList.add(f3);
		financeList.add(f4);
		financeList.add(f5);
		Mockito.when(financeRepo.findAll()).thenReturn(financeList);
		List<Finance> fin = financeService.findAllFinanceDetails();
		assertEquals(5, fin.size());
	}

	
	// save
	@Test
	void testSave() {
		Finance fin = new Finance(6,"Vinay",400,30,20,490);
		Mockito.when(financeRepo.save(fin)).thenReturn(fin);

		Finance persistedFin = financeService.save(fin);
		assertEquals(6, persistedFin.getFinanceId());
		assertEquals("Vinay", persistedFin.getPatientName());
		assertEquals(400, persistedFin.getRegistrationFee());
		assertEquals(30, persistedFin.getDoctorFee());
		assertEquals(20, persistedFin.getMedicinesAmount());
		assertEquals(490, persistedFin.getTotalFee());
	
	}


	// FindByFinanceId
	@Test
	void testFindByFinanceId() {
		Finance fin = new Finance(2,"Gagana",600,60,20,680);

		Mockito.when(financeRepo.findById(2)).thenReturn(Optional.of(fin));
		Finance persistedFin = financeService.findByFinanceId(2);

		assertEquals(2, persistedFin.getFinanceId());
		assertEquals("Gagana", persistedFin.getPatientName());
		assertEquals(600, persistedFin.getRegistrationFee());
		assertEquals(60, persistedFin.getDoctorFee());
		assertEquals(20, persistedFin.getMedicinesAmount());
		assertEquals(680, persistedFin.getTotalFee());
		
	}

	// DeleteFinanceByFinanceId
	@Test
	void testDeleteFinanceByFinanceId() {
		Finance fin = new Finance(6,"Vinay",400,30,20,490);

		Mockito.when(financeRepo.findById(6)).thenReturn(Optional.of(fin));
		financeRepo.deleteById(6);

		Finance persistedFin = financeService.deleteFinanceByFinanceId(6);
		assertEquals(6, persistedFin.getFinanceId());
		assertEquals("Vinay", persistedFin.getPatientName());
		assertEquals(400, persistedFin.getRegistrationFee());
		assertEquals(30, persistedFin.getDoctorFee());
		assertEquals(20, persistedFin.getMedicinesAmount());
		assertEquals(490, persistedFin.getTotalFee());
		
	}

	// updateFinance
	@Test
	void testUpdateFinance() {
		Finance fin = new Finance(3,"Krithi",400,60,20,480);

		Mockito.when(financeRepo.findById(3)).thenReturn(Optional.of(fin));
		Mockito.when(financeRepo.save(fin)).thenReturn(fin);

		Finance persistedFin = financeService.updateFinance(fin);
		
		assertEquals(3, persistedFin.getFinanceId());
		assertEquals("Krithi", persistedFin.getPatientName());
		assertEquals(400, persistedFin.getRegistrationFee());
		assertEquals(60, persistedFin.getDoctorFee());
		assertEquals(20, persistedFin.getMedicinesAmount());
		assertEquals(480, persistedFin.getTotalFee());
	}

}