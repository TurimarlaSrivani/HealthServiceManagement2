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


		@InjectMocks
		DiseaseServiceImpl desService;


		@MockBean
		IDiseaseRepository desRepo;

		@BeforeEach
		void init() {
			MockitoAnnotations.openMocks(this);
		}

		@Test
		void testCreateDisease() {
			Disease disease = new Disease(902, "Cardiovascular", "Physological","Fatigue","Two days");
			
			Mockito.when(desRepo.save(disease)).thenReturn(disease);
			
			Disease persistedDes = desService.save(disease);
			
			assertEquals(902, persistedDes.getDesId());
			assertEquals("Two days", persistedDes.getDesDur());
			assertEquals("Cardiovascular", persistedDes.getDesName());
			assertEquals("Fatigue", persistedDes.getDesSym());
			assertEquals("Physological", persistedDes.getDesType());
		
		}
		
		@Test
		void testDiseaseById() {
			Disease disease = new Disease(903,"Alzheimers","Deficiency","Memoryloss","two months");
			
			Mockito.when(desRepo.findById(903)).thenReturn(Optional.of(disease));
			
			Disease persistedDes = desService.findByDesId(903);
				
			assertEquals(903, disease.getDesId());
			assertEquals("Alzheimers", disease.getDesName());
			assertEquals("Memoryloss", disease.getDesSym());
			assertEquals("Deficiency", disease.getDesType());
		}
		
		@Test
		void testAllDisease() {
			Disease disease1 = new Disease(901,"One year","Diabetes","Weakness","Heriditory");
			Disease disease2 = new Disease( 902,"Two days","Cardiovascular","Fatigue","Physological");
			Disease disease3 = new Disease( 903,"Three months"," Alzeihmers","Memoryloss","Deficiency");
			
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
			
			Disease disease= new Disease(904,"Kidney disease","Deficiency","Swollen limbs","One month");
			
			Mockito.when(desRepo.findById(904)).thenReturn(Optional.of(disease));
			Mockito.when(desRepo.save(disease)).thenReturn(disease);
			
					
			Disease persistedDes = desService.save(disease);
			assertEquals(904, persistedDes.getDesId());
			assertEquals("One month", persistedDes.getDesDur());
			assertEquals("Kidney disease", persistedDes.getDesName());
			assertEquals("Swollen limbs", persistedDes.getDesSym());
			assertEquals("Deficiency", persistedDes.getDesType());
				}
			
			
		
		@Test
		void testDeleteDisease() {
				Disease disease= new Disease(904,"Kidney disease","Deficiency","Swollen limbs", "One month");
				
				Mockito.when(desRepo.findById(904)).thenReturn(Optional.of(disease));
				Mockito.when(desRepo.save(disease)).thenReturn(disease);
				Disease persistedDes = desService.save(disease);
				assertEquals(904, persistedDes.getDesId());
				assertEquals("One month", persistedDes.getDesDur());
				assertEquals("Kidney disease", persistedDes.getDesName());
				assertEquals("Swollen limbs", persistedDes.getDesSym());
				assertEquals("Deficiency", persistedDes.getDesType());
			}
}