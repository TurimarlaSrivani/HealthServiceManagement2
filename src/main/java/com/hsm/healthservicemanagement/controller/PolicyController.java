package com.hsm.healthservicemanagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.Policy;
import com.hsm.healthservicemanagement.exception.PolicyNotFoundException;
import com.hsm.healthservicemanagement.service.IPolicyService;
import com.hsm.healthservicemanagement.*;

@RestController
public class PolicyController {

	@Autowired
	IPolicyService PolicyServiceImpl;

	// READ
	@GetMapping("/policy/{id}")
	public ResponseEntity<Policy> getByPolicyId(@PathVariable("id") int policyId) {
		System.out.println(policyId);
		Policy policy = PolicyServiceImpl.getByPolicyId(policyId);
		if (policy == null) {
			throw new PolicyNotFoundException("Policy not found with Id" + policyId + "");
		}

		return new ResponseEntity<Policy>(policy, HttpStatus.OK);

	}

	@GetMapping("/policy")
	public List<Policy> getAllPolicies() {

		return PolicyServiceImpl.getAllPolicies();
	}

	@PostMapping("/policy")
	public Policy addPolicy(@RequestBody Policy policy) {
		System.out.println(policy.getMaximumAmount());
		Policy s = PolicyServiceImpl.create(policy);
		return s;
	}

	@DeleteMapping("/policy/{id}")
	public String deletePolicyById(@PathVariable("id") int policyId) {
		String s = PolicyServiceImpl.deleteByPolicyId(policyId);

		if (PolicyServiceImpl.deleteByPolicyId(policyId) == null) {
			throw new PolicyNotFoundException("Policy not found with this Id to delete" + policyId + "");
		}

		return s;
	}

	@PutMapping("/policy/{name}")
	public Policy updatePolicy(@PathVariable("name") String policyName, @RequestBody Policy policy) {
		Policy s = PolicyServiceImpl.updatePolicy(policy);

		if (PolicyServiceImpl.updatePolicy(policy) == null) {
			throw new PolicyNotFoundException("Policy not found with this name to update" + policy + "");
		}

		return s;
	}
}
