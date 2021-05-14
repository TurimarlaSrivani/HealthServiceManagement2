package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import com.cg.hsm.entity.Address;
import com.hsm.healthservicemanagement.entity.Disease;

@SpringBootTest
class DiseaseServiceTest {


		@Autowired
		IDiseaseService desService;
		
		@Test
		void testFindAllDisease() {
			List<Disease> diseases = desService.findAll();
			assertEquals(9, diseases.size());
		}
		
		
		@Test
		void testFindDiseaseById() {
			Disease disease = desService.findByDesId(501);
			assertEquals("Allergy", disease.getDesName());
			
		}
		
		// findEmployeeByName
		@Test
		void testFindDiseaseByName() {
			Disease disease = desService.findByDesName("Diabetes");
			assertEquals(603, disease.getDesId());
			assertEquals("Diabetes", disease.getDesName());
			assertEquals("Heriditory", disease.getDesType());
			assertEquals("Become Weak", disease.getDesSym());
			
		}
	
		@Test
		void testCreateDisease() {
			Disease disease= new Disease(501,"Allergy","Dificiency","Itching","two days");
			Disease persistedDes = desService.save(disease);
			assertEquals(501, persistedDes.getDesId());
			assertEquals("Allergy", persistedDes.getDesName());
			assertEquals("Dificiency", persistedDes.getDesType());
			assertEquals("Itching", persistedDes.getDesSym());
			assertEquals("two days", persistedDes.getDesDur());
		}
		
		@Test
		void testDisease() {
			Disease disease = new Disease(503,"Alzheimers","Heridity","shorttermmemoryloss","two months");
			Disease persistedDes = desService.delete(disease);
	
			assertEquals(503, persistedDes.getDesId());
			assertEquals("Alzheimers", persistedDes.getDesName());
			assertEquals("Heridity", persistedDes.getDesType());
			assertEquals("shorttermmemoryloss", persistedDes.getDesSym());
			assertEquals("two months", persistedDes.getDesDur());
		}
		
		

	}

