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

import com.hsm.healthservicemanagement.entity.Diet;
import com.hsm.healthservicemanagement.repository.IDietRepository;
@ExtendWith(SpringExtension.class)

class DietServiceMockitoTest {
	
	//Mock - imitating 
	//DB
	//Products
	//	@InjectMocks - injects DietService and inject dependent classes/interfaces
	//that are annotated with @Mock

	@InjectMocks 
	DietServiceImpl dService;
	
	//@MockBean - injecting external services
	
	@MockBean
	IDietRepository drepository;
	
	//Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	// save
	@Test
	void testSaveDiet() {
		
		
		Diet diet = new Diet(104,"low-crab","nuts","one week");
		Mockito.when(drepository.save(diet)).thenReturn(diet);
		Diet persistedDi=dService.save(diet);
		assertEquals("low-crab",persistedDi.getDietType());
		assertEquals(104,persistedDi.getDietId());
	    assertEquals("nuts",persistedDi.getFoodtoEat());
        assertEquals("one week",persistedDi.getDietDuration());

	}
	
	//viewByDietId
	@Test
	void testViewDietById() {
		Diet diet = new Diet(101,"keto","sprouts","one year");
		Mockito.when(drepository.findById(101)).thenReturn(Optional.of(diet));
		Diet persistedDi = dService.viewDietById(101);
		assertEquals("keto",persistedDi.getDietType());
		assertEquals(101,persistedDi.getDietId());
	    assertEquals("sprouts",persistedDi.getFoodtoEat());
		
	}
		
    //update
     @Test
    void testupdateDiet() {
    Diet diet = new Diet(103,"cardiacdiet","nuts","4 months");
	Mockito.when(drepository.findById(103)).thenReturn(Optional.of(diet));
	Mockito.when(drepository.save(diet)).thenReturn(diet);
	Diet persistedDi = dService.updateDiet(diet);
	assertEquals(103,persistedDi.getDietId());
	assertEquals("nuts",persistedDi.getFoodtoEat());
	assertEquals("cardiacdiet",persistedDi.getDietType());
	assertEquals("4 months",persistedDi.getDietDuration());
   }
     
     //delete
      @Test
    void testDeleteDiet(){
   
	Diet diet = new Diet(104,"low-crab","nuts","one week");
	Mockito.when(drepository.findById(104)).thenReturn(Optional.of(diet));
      drepository.deleteById(104);
   	Diet persistedDi = dService.delete(diet);
	assertEquals(104,persistedDi.getDietId());
	assertEquals("nuts",persistedDi.getFoodtoEat());
	assertEquals("low-crab",persistedDi.getDietType());
	assertEquals("one week",persistedDi.getDietDuration());
    }
     //viewAllDietDetails
     @Test
    void testViewAllDiet() {
	Diet diet1 = new Diet(101,"one year","keto","sprouts");
	Diet diet2= new Diet(102,"3 months","cardiacdiet","fruits,vegetables");
	List<Diet> dietList = new ArrayList();
	dietList.add(diet1);
	dietList.add(diet2);
	Mockito.when(drepository.findAll()).thenReturn(dietList);
	List<Diet> diet = dService.viewAll();
	assertEquals(2,diet.size());
		
	
   }
}
	