package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Policy;
import com.hsm.healthservicemanagement.repository.IPolicyRepository;

@Service
//serviceImpl implements the interface
public class PolicyServiceImpl implements IPolicyService {

	// Logger Declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PolicyServiceImpl.class);

	// autowiring policyRepository layer to this policyService layer
	@Autowired
	IPolicyRepository policyRepo;

	// serviceImpl for getByPolicyId
	@Override
	public Policy getByPolicyId(int id) {
		// setting logger info
		logger.info("Get the policy details By Id");

		Optional<Policy> p = policyRepo.findById(id);
		if (!p.isPresent()) {
			return null;
		}
		return p.get();
	}

	// serviceImpl for allPolicies
	@Override
	public List<Policy> getAllPolicies() {
		// setting logger info
		logger.info("Find all the details for policy");

		return policyRepo.findAll();
	}

	// serviceImpl for createPolicy
	@Override
	public Policy create(Policy policy) {
		// setting logger info
		logger.info("adding the details to policy");

		return policyRepo.save(policy);
	}

	// serviceImpl for deletePolicy type string
	@Override
	public String deleteByPolicyId(int id) {
		// setting logger info
		logger.info(" delete the policy by Id");

		Optional<Policy> p = policyRepo.findById(id);
		if (!p.isPresent()) {
			return null;
		}
		Policy policy = p.get();
		policyRepo.deleteById(id);
		System.out.println("Successfully deleted");
		return id + "";
	}

	// serviceImpl for updatePolicy
	@Override
	public Policy updatePolicy(Policy policy) {
		// setting logger info
		logger.info("update the policy details by name");

		Optional<Policy> p = policyRepo.findById(policy.getPolicyId());
		if (!p.isPresent()) {
			return null;
		}
		Policy policy1 = p.get();
		policy1.setPolicyId(policy.getPolicyId());
		policy1.setPolicyName(policy.getPolicyName());
		policy1.setCreateDate(policy.getCreateDate());
		policy1.setEndDate(policy.getEndDate());
		policy1.setMaximumAmount(policy.getMaximumAmount());
		return policyRepo.save(policy1);
	}

	// serviceImpl for deletePolicy for type int
	@Override
	public Policy deleteByPolId(int id) {
		// setting logger info
		logger.info(" delete the policy by Id");

		Optional<Policy> p = policyRepo.findById(id);
		if (!p.isPresent()) {
			return null;
		}
		policyRepo.deleteById(id);
		Policy policy = p.get();
		return policy;
	}

}