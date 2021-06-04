package com.hsm.healthservicemanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
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

	// Logger Declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PolicyServiceTest.class);

	@Autowired
	IPolicyService policyService;

	// Testing whether the policy gets saved to the database.
	@Test
	@Order(1)
	void testCreatePolicy() {
		// setting logger info
		logger.info("adding the details to policy");

		Policy policy = new Policy(201, "Individual Insurance Policy", LocalDate.parse("2013-04-10"),
				LocalDate.parse("2014-03-11"), 120000, null);
		Policy persistedPolicy = policyService.create(policy);
		assertEquals(201, persistedPolicy.getPolicyId());
		assertEquals("Individual Insurance Policy", persistedPolicy.getPolicyName());
		assertEquals(LocalDate.parse("2013-04-10"), persistedPolicy.getCreateDate());
		assertEquals(LocalDate.parse("2014-03-11"), persistedPolicy.getEndDate());
		assertEquals(120000, persistedPolicy.getMaximumAmount());
	}

	// Testing whether the policy gets updated to the database.
	@Test
	@Order(2)
	void testUpdatePolicy() {
		// setting logger info
		logger.info("update the policy details by name");

		Policy policy = new Policy();
		policy.setPolicyId(201);
		policy.setPolicyName("Individual Insurance Policy");
		policy.setCreateDate(LocalDate.parse("2013-04-10"));
		policy.setEndDate(LocalDate.parse("2014-03-11"));
		policy.setMaximumAmount(120000);
		Policy updatePol = policyService.updatePolicy(policy);
		assertEquals("Individual Insurance Policy", updatePol.getPolicyName());
	}

	// Testing whether the given id fetches the given policy or not.
	@Test
	@Order(3)
	void testGetPolicyByPolicyId() {
		// setting logger info
		logger.info("Get the policy details By Id");

		Policy policy = policyService.getByPolicyId(202);
		assertEquals("Family Floater Insurance Policy", policy.getPolicyName());
		assertEquals(LocalDate.parse("2010-11-01"), policy.getCreateDate());
		assertEquals(LocalDate.parse("2013-11-01"), policy.getEndDate());
		assertEquals(2500000, policy.getMaximumAmount());
	}

	// Testing whether the policy database has list of policy or null.
	@Test
	@Order(4)
	void testGetAllPolicies() {
		// setting logger info
		logger.info("Find all the details for policy");

		List<Policy> policies = policyService.getAllPolicies();
		assertEquals(8, policies.size());
	}

	// Testing whether the policy gets removed from the database
	@Test
	@Order(5)
	void testDeleteByPolicyId() {
		// setting logger info
		logger.info(" delete the policy by Id");

		Policy policy = new Policy(201, "Individual Insurance Policy", LocalDate.parse("2013-04-10"),
				LocalDate.parse("2014-03-11"), 120000, null);
		Policy persistedPolicy = policyService.deleteByPolId(201);
		assertEquals(201, persistedPolicy.getPolicyId());
		assertEquals("Individual Insurance Policy", persistedPolicy.getPolicyName());
		assertEquals(LocalDate.parse("2013-04-10"), persistedPolicy.getCreateDate());
		assertEquals(LocalDate.parse("2014-03-11"), persistedPolicy.getEndDate());
		assertEquals(120000, persistedPolicy.getMaximumAmount());
	}

}
