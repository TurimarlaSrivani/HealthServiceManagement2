package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.healthservicemanagement.entity.Policy;
import com.hsm.healthservicemanagement.repository.IPolicyRepository;

@Service
public class PolicyServiceImpl implements IPolicyService {

	@Autowired
	IPolicyRepository policyRepo;

	@Override
	public Policy getByPolicyId(int id) {

		Optional<Policy> p = policyRepo.findById(id);
         System.out.println(p);
		if (!p.isPresent()) {
			return null;
		}
		return p.get();
	}

	@Override
	public List<Policy> getAllPolicies() {

		return policyRepo.findAll();
	}

	@Override
	public Policy create(Policy policy) {
		return policyRepo.save(policy);

	}

	@Override
	public String deleteByPolicyId(int id) {

		Optional<Policy> p = policyRepo.findById(id);
		if (!p.isPresent()) {
			return null;
		}
		Policy policy = p.get();
		policyRepo.deleteById(id);
		System.out.println("Successfully deleted");
		return id + "";
	}

	@Override
	public Policy updatePolicy(Policy policy) {
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

	@Override
	public Policy deleteByPolId(int id) {

		Optional<Policy> p = policyRepo.findById(id);
		if (!p.isPresent()) {
			return null;
		}
		policyRepo.deleteById(id);
		Policy policy = p.get();

		return policy;

	}

}
