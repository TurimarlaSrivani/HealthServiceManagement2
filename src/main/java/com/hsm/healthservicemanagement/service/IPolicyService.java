package com.hsm.healthservicemanagement.service;

import java.util.List;

import com.hsm.healthservicemanagement.entity.Policy;

public interface IPolicyService {

	Policy getByPolicyId(int id);

	List<Policy> getAllPolicies();

	Policy create(Policy policy);

	String deleteByPolicyId(int id);

	Policy updatePolicy(Policy policyName);

	Policy deleteByPolId(int id);

}
