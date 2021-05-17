package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsm.healthservicemanagement.entity.Policy;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PolicyServiceTest {

	@Autowired
	IPolicyService policyService;

	@Test
	@Order(1)
	void testCreatePolicy() {
		Policy policy = new Policy(104, "Travel", LocalDate.parse("2014-04-12"), LocalDate.parse("2015-04-11"), 40000);
		Policy persistedPolicy = policyService.create(policy);
		assertEquals(104, persistedPolicy.getPolicyId());
		assertEquals("Travel", persistedPolicy.getPolicyName());

		assertEquals(LocalDate.parse("2014-04-12"), persistedPolicy.getCreateDate());
		assertEquals(LocalDate.parse("2015-04-11"), persistedPolicy.getEndDate());
		assertEquals(40000, persistedPolicy.getMaximumAmount());
	}

	@Test
	@Order(2)
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

	@Test
	@Order(3)
	void testGetPolicyByPolicyId() {
		Policy policy = policyService.getByPolicyId(102);
		assertEquals("Health", policy.getPolicyName());
		assertEquals(LocalDate.parse("2013-03-12"), policy.getCreateDate());
		assertEquals(LocalDate.parse("2014-03-11"), policy.getEndDate());
		assertEquals(500000, policy.getMaximumAmount());
	}

	@Test
	@Order(4)
	void testGetAllPolicies() {
		List<Policy> policies = policyService.getAllPolicies();
		assertEquals(4, policies.size());
	}

	@Test
	@Order(5)
	void testDeleteByPolicyId() {
		String policy = policyService.deleteByPolicyId(104);
		assertEquals(104, Integer.parseInt(policy.trim()));
	}

}
