package com.hsm.healthservicemanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.Policy;
import com.hsm.healthservicemanagement.exception.PolicyNotFoundException;
import com.hsm.healthservicemanagement.service.IPolicyService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/policy-service")
public class PolicyController {

	// Logger Declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PolicyController.class);

	// autowiring policyService layer to this policyController layer
	@Autowired
	IPolicyService PolicyServiceImpl;

	// get method uses policyId to get specific data
	@GetMapping("/policy/{id}")
	public ResponseEntity<Policy> getByPolicyId(@PathVariable int id) {
		// setting logger info
		logger.info("Get the policy details By Id");

		Policy policy = PolicyServiceImpl.getByPolicyId(id);
		// throws exception if policy not found with id
		if (policy == null) {
			throw new PolicyNotFoundException("Policy not found with Id" + id + "");
		}
		return new ResponseEntity<Policy>(policy, HttpStatus.OK);
	}

	// get method lists all the data
	@GetMapping("/policy")
	public List<Policy> getAllPolicies() {
		// setting logger info
		logger.info("Find all the details for policy");

		return PolicyServiceImpl.getAllPolicies();
	}

	// post method is used for adding the policy
	@PostMapping("/policy")
	public Policy addPolicy(@Valid @RequestBody Policy policy) {
		// setting logger info
		logger.info("adding the details to policy");

		Policy s = PolicyServiceImpl.create(policy);
		return s;
	}

	// delete method is used for Deleting a policy through id
	@DeleteMapping("/policy/{id}")
	public String deletePolicyById(@PathVariable("id") int policyId) {
		// setting logger info
		logger.info(" delete the policy by Id");

		String s = PolicyServiceImpl.deleteByPolicyId(policyId);
		// throws an exception if policy not found with id
		if (s == null) {
			throw new PolicyNotFoundException("Policy not found with this Id to delete" + policyId + "");
		}
		return new String("successfully deleted " + s);
	}

	// put method is used for Updating the policy through name
	@PutMapping("/policy/{name}")
	public Policy updatePolicy(@PathVariable("name") String policyName, @Valid @RequestBody Policy policy) {
		// setting logger info
		logger.info("update the policy details by name");

		Policy s = PolicyServiceImpl.updatePolicy(policy);
		// throws an exception if policy not found with name
		if (PolicyServiceImpl.updatePolicy(policy) == null) {
			throw new PolicyNotFoundException("Policy not found with this name to update" + policy + "");
		}
		return s;
	}
}
