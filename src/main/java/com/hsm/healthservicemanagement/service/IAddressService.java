package com.hsm.healthservicemanagement.service;

import java.util.List;

import com.hsm.healthservicemanagement.entity.Address;

public interface IAddressService {

	Address findAddressById(int id);
	List<Address> findAllAddresses();
	Address save(Address address);
	Address deleteAddressById(int id);
}