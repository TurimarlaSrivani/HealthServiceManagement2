package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

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

import com.hsm.healthservicemanagement.entity.Disease;
import com.hsm.healthservicemanagement.repository.IDiseaseRepository;

@ExtendWith(SpringExtension.class)
class DiseaseServiceMockitoTest {

		// Mock - imitating
		// DB -
		// Product -

		// @InjectMock - injects EmployeeService and inject dependent classes/interfaces
		// that are annotated with @Mock
		@InjectMocks
		DiseaseServiceImpl desService;

		// @MockBean - injecting external services

		@MockBean
		IDiseaseRepository desRepo;

		// Initialization of mock objects
		@BeforeEach
		void init() {
			MockitoAnnotations.openMocks(this);
		}

		@Test
		void testCreateDisease() {
			Disease disease = new Disease(602,"Covid","Infectious","Cold","one week");
			
			Mockito.when(desRepo.save(disease)).thenReturn(disease);
			
			Disease persistedDes = desService.save(disease);
			
			assertEquals(602, persistedDes.getDesId());
			assertEquals("Covid", persistedDes.getDesName());
			assertEquals("Infectious", persistedDes.getDesType());
			assertEquals("Cold", persistedDes.getDesSym());
			assertEquals("one week", persistedDes.getDesDur());
		}
		
		@Test
		void testDiseaseById() {
			Disease disease = new Disease(503,"Alzheimers","Heridity","shorttermmemoryloss","two months");
			
			Mockito.when(desRepo.findById(503)).thenReturn(Optional.of(disease));
			
			Disease persistedDes = desService.findByDesId(503);
			
			assertEquals(503, persistedDes.getDesId());
			assertEquals("Alzheimers", persistedDes.getDesName());
			assertEquals("Heridity", persistedDes.getDesType());
			assertEquals("shorttermmemoryloss", persistedDes.getDesSym());
			assertEquals("two months", persistedDes.getDesDur());
		}
		
		@Test
		void testAllDisease() {
			Disease disease1 = new Disease(501,"Allergy","Dificiency","Itching","two days");
			Disease disease2 = new Disease(502,"Covid","Infectious","Cold","one week");
			Disease disease3 = new Disease(503,"Alzheimers","Heridity","shorttermmemoryloss","two months");
			
			List<Disease> diseaseList = new ArrayList<>();
			diseaseList.add(disease1);
			diseaseList.add(disease2);
			diseaseList.add(disease3);
			
			Mockito.when(desRepo.findAll()).thenReturn(diseaseList);
			
			List<Disease > diseases = desService.findAll();
			
			assertEquals(3, diseases.size());
			
		}
		
		@Test
		void testUpdateDisease() {
			Disease  disease = new Disease (504,"Allergy","Dificiency","Itching","five days");
			
			Mockito.when(desRepo.findById(504)).thenReturn(Optional.of(disease));
			Mockito.when(desRepo.save(disease)).thenReturn(disease);
			
			Disease persistedDes = desService.update(disease);
			
			assertEquals(504, persistedDes.getDesId());
			assertEquals("Allergy", persistedDes.getDesName());
			assertEquals("Dificiency", persistedDes.getDesType());
			assertEquals("Itching", persistedDes.getDesSym());
			assertEquals("five days", persistedDes.getDesDur());
		}
		
		@Test
		void testDeleteDisease() {
			Disease disease = new Disease(504,"Allergy","Dificiency","Itching","five days");
			
			Mockito.when(desRepo.findById(504)).thenReturn(Optional.of(disease));
			desRepo.deleteById(504);
			Disease persistedDes = desService.deleteByDesId(504);
			
			assertEquals(504, persistedDes.getDesId());
			assertEquals("Allergy", persistedDes.getDesName());
			assertEquals("Dificiency", persistedDes.getDesType());
			assertEquals("Itching", persistedDes.getDesSym());
			assertEquals("five days", persistedDes.getDesDur());
		}
		

	}

