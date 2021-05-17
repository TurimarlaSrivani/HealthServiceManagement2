package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.Policy;

@SpringBootTest
class PolicyServiceTest {

	@Autowired

	IPolicyService policyService;

	@Test
	void testGetByPoliciesId() {
		Policy policy = policyService.getByPolicyId(102);
		assertEquals("Health", policy.getPolicyName());
		assertEquals(LocalDate.parse("2013-03-12"), policy.getCreateDate());
		assertEquals(LocalDate.parse("2014-03-11"), policy.getEndDate());
		assertEquals(500000, policy.getMaximumAmount());
	}

	@Test
	void testGetAllPolicies() {
		List<Policy> policies = policyService.getAllPolicies();
		assertEquals(5, policies.size());
	}

	@Test
	void testCreatePolicy() {
		Policy policy = new Policy("Travel", LocalDate.parse("2014-04-12"), LocalDate.parse("2015-04-11"), 40000);
		Policy persistedPolicy = policyService.create(policy);
		assertEquals(104, persistedPolicy.getPolicyId());
		assertEquals("Travel", persistedPolicy.getPolicyName());

		assertEquals(LocalDate.parse("2014-04-12"), persistedPolicy.getCreateDate());
		assertEquals(LocalDate.parse("2015-04-11"), persistedPolicy.getEndDate());
		assertEquals(40000, persistedPolicy.getMaximumAmount());
	}

	@Test
	void testDeleteByPolicyId() {
		String policy = policyService.deleteByPolicyId(101);
		assertEquals(101, Integer.parseInt(policy.trim()));
	}

	@Test
	void testUpdatePolicy() {
		Policy policy = new Policy();
		policy.setPolicyId(104);
		policy.setPolicyName("Travel");
		policy.setCreateDate(LocalDate.parse("2014-04-12"));
		policy.setEndDate(LocalDate.parse("2015-04-11"));
		policy.setMaximumAmount(40000);

		Policy updatePol = policyService.updatePolicy(policy);
		assertEquals(104, updatePol.getPolicyId());

	}

}
