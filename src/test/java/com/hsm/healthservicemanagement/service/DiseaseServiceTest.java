package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.Disease;

@SpringBootTest
class DiseaseServiceTest {


		@Autowired
		IDiseaseService desService;
		
		@Test
		@Order(2)
		void testFindAllDisease() {
			List<Disease> diseases = desService.findAll();
			assertEquals(4, diseases.size());
		}
		
		
		@Test
		@Order(3)
		void testFindDiseaseById() {
			Disease disease = desService.findByDesId(901);
			assertEquals("Diabetes", disease.getDesName());
			
		}
		
		// findEmployeeByName
		@Test
		@Order(4)
		void testFindDiseaseByName() {
			Disease disease = desService.findByDesName("Alzeihmers");
			assertEquals(903, disease.getDesId());
			assertEquals("Alzeihmers", disease.getDesName());
			assertEquals("Memoryloss", disease.getDesSym());
			assertEquals("Deficiency", disease.getDesType());
			
		}
	
		@Test
		@Order(1)
		void testCreateDisease() {
			Disease disease= new Disease(904, "Kidney disease","Deficiency","Swollen limbs", "One month");
			
			Disease persistedDes = desService.save(disease);
			assertEquals(904, persistedDes.getDesId());
			assertEquals("One month", persistedDes.getDesDur());
			assertEquals("Kidney disease", persistedDes.getDesName());
			assertEquals("Swollen limbs", persistedDes.getDesSym());
			assertEquals("Deficiency", persistedDes.getDesType());
		}
		
		@Test
		@Order(5)
		void testDisease() {
            Disease disease= new Disease(904, "Kidney disease","Deficiency","Swollen limbs", "One month");
			
			Disease persistedDes = desService.save(disease);
			assertEquals(904, persistedDes.getDesId());
			assertEquals("One month", persistedDes.getDesDur());
			assertEquals("Kidney disease", persistedDes.getDesName());
			assertEquals("Swollen limbs", persistedDes.getDesSym());
			assertEquals("Deficiency", persistedDes.getDesType());
		
		}
		
	}