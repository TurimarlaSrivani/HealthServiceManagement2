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
		Policy policy = new Policy(201, "Individual Insurance Policy", LocalDate.parse("2013-04-10"),
				LocalDate.parse("2014-03-11"), 120000, null);
		Policy persistedPolicy = policyService.create(policy);
		assertEquals(201, persistedPolicy.getPolicyId());
		assertEquals("Individual Insurance Policy", persistedPolicy.getPolicyName());

		assertEquals(LocalDate.parse("2013-04-10"), persistedPolicy.getCreateDate());
		assertEquals(LocalDate.parse("2014-03-11"), persistedPolicy.getEndDate());
		assertEquals(120000, persistedPolicy.getMaximumAmount());
	}

	@Test
	@Order(2)
	void testUpdatePolicy() {
		Policy policy = new Policy();
		policy.setPolicyId(201);
		policy.setPolicyName("Individual Insurance Policy");
		policy.setCreateDate(LocalDate.parse("2013-04-10"));
		policy.setEndDate(LocalDate.parse("2014-03-11"));
		policy.setMaximumAmount(120000);

		Policy updatePol = policyService.updatePolicy(policy);
		assertEquals(201, updatePol.getPolicyId());

		Policy policy = new Policy(104, "Travel", LocalDate.parse("2014-04-12"), LocalDate.parse("2015-04-11"), 40000);
		Policy persistedPolicy = policyService.create(policy);
		assertEquals(104, persistedPolicy.getPolicyId());
		assertEquals("Travel", persistedPolicy.getPolicyName());

	}

	@Test
	@Order(3)
	void testGetPolicyByPolicyId() {
		Policy policy = policyService.getByPolicyId(202);
		assertEquals("Family Floater Insurance Policy", policy.getPolicyName());
		assertEquals(LocalDate.parse("2010-11-01"), policy.getCreateDate());
		assertEquals(LocalDate.parse("2013-11-01"), policy.getEndDate());
		assertEquals(2500000, policy.getMaximumAmount());
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
		Policy policy = new Policy(201,"Individual Insurance Policy", LocalDate.parse("2013-04-10"), LocalDate.parse("2014-03-11"), 120000);
		Policy persistedPolicy = policyService.deleteByPolId(201);
		assertEquals(201, persistedPolicy.getPolicyId());
		assertEquals("Individual Insurance Policy", persistedPolicy.getPolicyName());
		assertEquals(LocalDate.parse("2013-04-10"), persistedPolicy.getCreateDate());
		assertEquals(LocalDate.parse("2014-03-11"), persistedPolicy.getEndDate());
		assertEquals(120000, persistedPolicy.getMaximumAmount());
	}


}

}

