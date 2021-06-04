package com.hsm.healthservicemanagement.service;

import java.util.List;

import com.hsm.healthservicemanagement.entity.Policy;

//interface for service
public interface IPolicyService {

	// Method to be override by the implementing class
	// get by policyId
	Policy getByPolicyId(int id);

	// Method to be override by the implementing class
	// getAllpolicyDetails
	List<Policy> getAllPolicies();

	// Method to override by the implementing class
	// create/save policy
	Policy create(Policy policy);

	// Method to override by the implementing class
	// delete by PolicyId
	String deleteByPolicyId(int id);

	// Method to be override by the implementing class
	// updatePolicyDetails
	Policy updatePolicy(Policy policyName);

	// Method to override by the implementing class
	// delete by PolicyId
	Policy deleteByPolId(int id);

}
