package com.hsm.healthservicemanagement.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.hsm.healthservicemanagement.entity.Address;

@Service
//Service layer method
public interface IAddressService {

	// Method to be override by the implementing class
	// findAddressById
	Address findAddressById(int id);

	// Method to be override by the implementing class
	// ListAllAddress
	List<Address> findAllAddresses();

	// Method to be override by the implementing class
	// save address
	Address save(Address address);

	// Method to be override by the implementing class
	// deleteAddressByAddressId
	Address deleteAddressById(int id);
}