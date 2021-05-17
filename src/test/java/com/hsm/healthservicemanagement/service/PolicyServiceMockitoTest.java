package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
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

import com.hsm.healthservicemanagement.entity.Policy;
import com.hsm.healthservicemanagement.repository.IPolicyRepository;

@ExtendWith(SpringExtension.class)
public class PolicyServiceMockitoTest {

	// @InjectMocks - Injects EmployeeService and inject dependency
	// classes/interfaces
	@InjectMocks
	PolicyServiceImpl policyService;

	// @MockBean - Injects external services
	@MockBean
	IPolicyRepository policyRepo;

	// Initialization of Mock objects
	@BeforeEach
	void inint() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetByPoliciesId() {
		Policy policy = new Policy("Travel", LocalDate.parse("2014-04-12"), LocalDate.parse("2015-04-11"), 40000);

		Mockito.when(policyRepo.findById(150)).thenReturn(Optional.of(policy));

		Policy persistedPolicy = policyService.getByPolicyId(150);
		assertEquals(150, persistedPolicy.getPolicyId());
		assertEquals("Travel", persistedPolicy.getPolicyName());
		assertEquals(LocalDate.parse("2014-04-12"), persistedPolicy.getCreateDate());
		assertEquals(LocalDate.parse("2015-04-11"), persistedPolicy.getEndDate());
		assertEquals(40000, persistedPolicy.getMaximumAmount());

	}

	@Test
	void testAllPolicies() {
		Policy policy1 = new Policy("Travel", LocalDate.parse("2014-04-12"), LocalDate.parse("2015-04-11"), 40000);
		Policy policy2 = new Policy("health23", LocalDate.parse("2014-04-12"), LocalDate.parse("2015-04-11"),
				4000);
		Policy policy3 = new Policy("heal", LocalDate.parse("2014-04-12"), LocalDate.parse("2015-04-11"), 400);

		List<Policy> policyList = new ArrayList<>();
		policyList.add(policy1);
		policyList.add(policy2);
		policyList.add(policy3);

		Mockito.when(policyRepo.findAll()).thenReturn(policyList);

		List<Policy> policies = policyService.getAllPolicies();
		assertEquals(3, policies.size());

	}

	@Test
	void testCreatePolicy() {
		Policy policy = new Policy("Travel", LocalDate.parse("2014-04-12"), LocalDate.parse("2015-04-11"), 40000);

		Mockito.when(policyRepo.save(policy)).thenReturn(policy);

		Policy persistedPolicy = policyService.create(policy);
		assertEquals(104, persistedPolicy.getPolicyId());
		assertEquals("Travel", persistedPolicy.getPolicyName());
		assertEquals(LocalDate.parse("2014-04-12"), persistedPolicy.getCreateDate());
		assertEquals(LocalDate.parse("2015-04-11"), persistedPolicy.getEndDate());
		assertEquals(40000, persistedPolicy.getMaximumAmount());
	}

	@Test
	void testDeletePolicy() {
		Policy policy = new Policy("History", LocalDate.parse("2014-04-23"), LocalDate.parse("2015-04-21"), 4);

		Mockito.when(policyRepo.findById(13)).thenReturn(Optional.of(policy));
		policyRepo.deleteById(123);

		Policy persistedPolicy = policyService.deleteByPolId(13);
		assertEquals(13, persistedPolicy.getPolicyId());
		assertEquals("History", persistedPolicy.getPolicyName());
		assertEquals(LocalDate.parse("2014-04-23"), persistedPolicy.getCreateDate());
		assertEquals(LocalDate.parse("2015-04-21"), persistedPolicy.getEndDate());
		assertEquals(4, persistedPolicy.getMaximumAmount());
	}

	@Test
	void testUpdatePolicy() {
		Policy policy = new Policy("History", LocalDate.parse("2014-04-23"), LocalDate.parse("2015-04-21"), 4);

		Mockito.when(policyRepo.findById(123)).thenReturn(Optional.of(policy));
		Mockito.when(policyRepo.save(policy)).thenReturn(policy);

		Policy persistedPolicy = policyService.updatePolicy(policy);
		assertEquals(123, persistedPolicy.getPolicyId());
		assertEquals("History", persistedPolicy.getPolicyName());
		assertEquals(LocalDate.parse("2014-04-23"), persistedPolicy.getCreateDate());
		assertEquals(LocalDate.parse("2015-04-21"), persistedPolicy.getEndDate());
		assertEquals(4, persistedPolicy.getMaximumAmount());
	}

}
