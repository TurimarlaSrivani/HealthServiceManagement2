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
		
		
		Diet diet = new Diet(40,"cardinodiet","vegetables",50);
		Mockito.when(drepository.save(diet)).thenReturn(diet);
		Diet persistedDi=dService.save(diet);
		assertEquals("cardinodiet",persistedDi.getDietType());
		assertEquals(40,persistedDi.getDietId());
	    assertEquals("vegetables",persistedDi.getFoodtoEat());

	}
	
	//viewByDietId
	@Test
	void testViewDietById() {
		Diet diet = new Diet(30,"paleno diet","fruits",40);
		Mockito.when(drepository.findById(30)).thenReturn(Optional.of(diet));
		Diet persistedDi = dService.viewDietById(30);
		assertEquals("paleno diet",persistedDi.getDietType());
		assertEquals(30,persistedDi.getDietId());
	    assertEquals("fruits",persistedDi.getFoodtoEat());
		
	}
		
    //update
     @Test
    void testupdateDiet() {
    Diet diet = new Diet(40,"cardinodiet","vegetables",50);
	Mockito.when(drepository.findById(40)).thenReturn(Optional.of(diet));
	Mockito.when(drepository.save(diet)).thenReturn(diet);
	Diet persistedDi = dService.updateDiet(diet);
	assertEquals(40,persistedDi.getDietId());
	assertEquals("vegetables",persistedDi.getFoodtoEat());
	assertEquals("cardinodiet",persistedDi.getDietType());
	assertEquals(50,persistedDi.getDietDuration());
   }
     
     //delete
      @Test
    void testDeleteDiet(){
   
	Diet diet = new Diet(40,"cardinodiet","vegetables",50);
	Mockito.when(drepository.findById(40)).thenReturn(Optional.of(diet));
      drepository.deleteById(40);
   	Diet persistedDi = dService.delete(diet);
	assertEquals(40,persistedDi.getDietId());
	assertEquals("vegetables",persistedDi.getFoodtoEat());
	assertEquals("cardinodiet",persistedDi.getDietType());
	assertEquals(50,persistedDi.getDietDuration());
    }
     //viewAllDietDetails
     @Test
    void testViewAllDiet() {
	Diet diet1 = new Diet(30,"paleno diet","fruits",40);
	Diet diet2= new Diet(40,"cardinodiet","vegetables",50);
	List<Diet> dietList = new ArrayList();
	dietList.add(diet1);
	dietList.add(diet2);
	Mockito.when(drepository.findAll()).thenReturn(dietList);
	List<Diet> diet = dService.viewAll();
	assertEquals(2,diet.size());
		
	
   }
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		