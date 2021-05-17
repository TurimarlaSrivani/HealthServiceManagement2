package com.hsm.healthservicemanagement.repository;


import static org.junit.jupiter.api.Assertions.*;

//import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.Disease;

@SpringBootTest

class DiseaseRepositoryTest {


		@Autowired
		IDiseaseRepository desRepo;
		
		@Test
		void testCreateDisease() {
			Disease disease = new Disease(501,"Allergy","Dificiency","Itching","two days");
			
			Disease persistedDes = desRepo.save(disease);
			
			assertEquals(501, persistedDes.getDesId());
			assertEquals("Allergy", persistedDes.getDesName());
			assertEquals("Dificiency", persistedDes.getDesType());
			assertEquals("Itching", persistedDes.getDesSym());
			assertEquals("two days", persistedDes.getDesDur());
			
		}

	}
