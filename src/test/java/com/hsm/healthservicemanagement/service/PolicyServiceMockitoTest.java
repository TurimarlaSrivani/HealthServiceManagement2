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

	// @InjectMocks - Injects PolicyService and inject dependency
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

	// testing getByPolicyId using mockito
	@Test
	void testGetByPoliciesId() {
		Policy policy = new Policy(200, "health policy", LocalDate.parse("2014-04-12"), LocalDate.parse("2015-04-11"),
				40000, null);

		Mockito.when(policyRepo.findById(150)).thenReturn(Optional.of(policy));

		Policy persistedPolicy = policyService.getByPolicyId(150);
		assertEquals(200, persistedPolicy.getPolicyId());
		assertEquals("health policy", persistedPolicy.getPolicyName());
		assertEquals(LocalDate.parse("2014-04-12"), persistedPolicy.getCreateDate());
		assertEquals(LocalDate.parse("2015-04-11"), persistedPolicy.getEndDate());
		assertEquals(40000, persistedPolicy.getMaximumAmount());

	}

	// testing allPolicies using mockito
	@Test
	void testAllPolicies() {
		Policy policy1 = new Policy(102, "health policy", LocalDate.parse("2014-04-12"), LocalDate.parse("2015-04-11"),
				40000, null);
		Policy policy2 = new Policy(106, "health23 policy", LocalDate.parse("2014-04-12"),
				LocalDate.parse("2015-04-11"), 4000, null);
		Policy policy3 = new Policy(103, "heal policy", LocalDate.parse("2014-04-12"), LocalDate.parse("2015-04-11"),
				400, null);
		List<Policy> policyList = new ArrayList<>();
		policyList.add(policy1);
		policyList.add(policy2);
		policyList.add(policy3);
		Mockito.when(policyRepo.findAll()).thenReturn(policyList);
		List<Policy> policies = policyService.getAllPolicies();
		assertEquals(3, policies.size());
	}

	// testing createPolicy using mockito
	@Test
	void testCreatePolicy() {
		Policy policy = new Policy(104, "individual policy", LocalDate.parse("2014-04-12"),
				LocalDate.parse("2015-04-11"), 40000, null);
		Mockito.when(policyRepo.save(policy)).thenReturn(policy);
		Policy persistedPolicy = policyService.create(policy);
		assertEquals(104, persistedPolicy.getPolicyId());
		assertEquals("individual policy", persistedPolicy.getPolicyName());
		assertEquals(LocalDate.parse("2014-04-12"), persistedPolicy.getCreateDate());
		assertEquals(LocalDate.parse("2015-04-11"), persistedPolicy.getEndDate());
		assertEquals(40000, persistedPolicy.getMaximumAmount());
	}

	// testing deletePolicy using mockito
	@Test
	void testDeletePolicy() {
		Policy policy = new Policy(13, "individual policy", LocalDate.parse("2014-04-23"),
				LocalDate.parse("2015-04-21"), 4, null);
		Mockito.when(policyRepo.findById(13)).thenReturn(Optional.of(policy));
		policyRepo.deleteById(123);
		Policy persistedPolicy = policyService.deleteByPolId(13);
		assertEquals(13, persistedPolicy.getPolicyId());
		assertEquals("individual policy", persistedPolicy.getPolicyName());
		assertEquals(LocalDate.parse("2014-04-23"), persistedPolicy.getCreateDate());
		assertEquals(LocalDate.parse("2015-04-21"), persistedPolicy.getEndDate());
		assertEquals(4, persistedPolicy.getMaximumAmount());
	}

	// testing updatePolicy using mockito
	@Test
	void testUpdatePolicy() {
		Policy policy = new Policy(123, "individual policy", LocalDate.parse("2014-04-23"),
				LocalDate.parse("2015-04-21"), 4, null);
		Mockito.when(policyRepo.findById(123)).thenReturn(Optional.of(policy));
		Mockito.when(policyRepo.save(policy)).thenReturn(policy);
		Policy persistedPolicy = policyService.updatePolicy(policy);
		assertEquals(123, persistedPolicy.getPolicyId());
		assertEquals("individual policy", persistedPolicy.getPolicyName());
		assertEquals(LocalDate.parse("2014-04-23"), persistedPolicy.getCreateDate());
		assertEquals(LocalDate.parse("2015-04-21"), persistedPolicy.getEndDate());
		assertEquals(4, persistedPolicy.getMaximumAmount());
	}

}
