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
	DiseaseServiceImpl diseaseService;

	@MockBean
	IDiseaseRepository diseaseRepo;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	// Testing whether the disease gets created at the database
	@Test
	void testCreateDisease() {
		Disease disease = new Disease(902, "Cardiovascular", "Physological", "Fatigue");

		Mockito.when(diseaseRepo.save(disease)).thenReturn(disease);

		Disease persistedDisease = diseaseService.save(disease);

		assertEquals(902, persistedDisease.getDiseaseId());
		assertEquals("Cardiovascular", persistedDisease.getDiseaseName());
		assertEquals("Physological", persistedDisease.getDiseaseType());
		assertEquals("Fatigue", persistedDisease.getDiseaseSymptoms());

	}

	// Testing whether the diseases gets fetched
	@Test
	void testDiseaseById() {
		Disease disease = new Disease(903, "Alzheimers", "Deficiency", "Memoryloss");

		Mockito.when(diseaseRepo.findById(903)).thenReturn(Optional.of(disease));

		Disease persistedDisease = diseaseService.findByDiseaseId(903);

		assertEquals(903, disease.getDiseaseId());
		assertEquals("Alzheimers", disease.getDiseaseName());
		assertEquals("Deficiency", disease.getDiseaseType());
		assertEquals("Memoryloss", disease.getDiseaseSymptoms());

	}

	// Testing whether all diseases gets updated at the database
	@Test
	void testAllDisease() {
		Disease disease1 = new Disease(901, "Diabetes", "Weakness", "Heriditory");
		Disease disease2 = new Disease(902, "Cardiovascular", "Fatigue", "Physological");
		Disease disease3 = new Disease(903, " Alzeihmers", "Memoryloss", "Deficiency");

		List<Disease> diseaseList = new ArrayList<>();
		diseaseList.add(disease1);
		diseaseList.add(disease2);
		diseaseList.add(disease3);

		Mockito.when(diseaseRepo.findAll()).thenReturn(diseaseList);

		List<Disease> diseases = diseaseService.findAll();

		assertEquals(3, diseases.size());

	}

	// Testing whether the disease gets updated at the database
	@Test
	void testUpdateDisease() {

		Disease disease = new Disease(904, "Kidney disease", "Deficiency", "Swollen limbs");

		Mockito.when(diseaseRepo.findById(904)).thenReturn(Optional.of(disease));
		Mockito.when(diseaseRepo.save(disease)).thenReturn(disease);

		Disease persistedDisease = diseaseService.save(disease);
		assertEquals(904, persistedDisease.getDiseaseId());
		assertEquals("Kidney disease", persistedDisease.getDiseaseName());
		assertEquals("Deficiency", persistedDisease.getDiseaseType());
		assertEquals("Swollen limbs", persistedDisease.getDiseaseSymptoms());

	}

	// Testing whether the disease gets deleted at the database
	@Test
	void testDeleteDisease() {
		Disease disease = new Disease(904, "Kidney disease", "Deficiency", "Swollen limbs");

		Mockito.when(diseaseRepo.findById(904)).thenReturn(Optional.of(disease));
		Mockito.when(diseaseRepo.save(disease)).thenReturn(disease);
		Disease persistedDisease = diseaseService.save(disease);
		assertEquals(904, persistedDisease.getDiseaseId());
		assertEquals("Kidney disease", persistedDisease.getDiseaseName());
		assertEquals("Deficiency", persistedDisease.getDiseaseType());
		assertEquals("Swollen limbs", persistedDisease.getDiseaseSymptoms());
	}
}