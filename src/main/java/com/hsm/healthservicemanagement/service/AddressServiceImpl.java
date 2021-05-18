package com.hsm.healthservicemanagement.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hsm.healthservicemanagement.entity.Address;
import com.hsm.healthservicemanagement.repository.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	IAddressRepository addressRepo;

	@Override
	public Address findAddressById(int id) {
		Optional<Address> address = addressRepo.findById(id);
		if (!address.isPresent()) {
			return null;
		}
		return address.get();
	}

	@Override
	public List<Address> findAllAddresses() {
		return addressRepo.findAll();
	}

	@Override
	public Address save(Address address) {
		return addressRepo.save(address);
	}

	@Override
	public Address deleteAddressById(int id) {
		Optional<Address> address = addressRepo.findById(id);
		if (!address.isPresent()) {
			return null;
		}
		addressRepo.delete(address.get());
		return address.get();
	}
}
