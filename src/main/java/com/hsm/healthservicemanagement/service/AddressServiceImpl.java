package com.hsm.healthservicemanagement.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hsm.healthservicemanagement.entity.Address;
import com.hsm.healthservicemanagement.repository.IAddressRepository;

@Service
//Implementation of service layer method by implements method
public class AddressServiceImpl implements IAddressService {

	@Autowired
	IAddressRepository addressRepo;
	// Used to store the given address Object passes from the controller
	
	// Logger declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(AddressServiceImpl.class);

	// Get a specific address of the given ID
	// findAddressById
	@Override
	public Address findAddressById(int id) {
		// setting logger info
		logger.info("Find the address details By Id");
		Optional<Address> address = addressRepo.findById(id);
		if (!address.isPresent()) {
			return null;
		}
		return address.get();
	}

	// Used to list all the address from the database
	// findAllAddressDetails
	@Override
	public List<Address> findAllAddresses() {
		// setting logger info
		logger.info("save the details of the address");
		return addressRepo.findAll();
	}

	// Used to store the given address object that passes from the controller
	// save address
	@Override
	public Address save(Address address) {
		// setting logger info
	    logger.info("save the details of the address");
		return addressRepo.save(address);
	}

	// Used to delete the address by id
	// deleteByAddressId
	@Override
	public Address deleteAddressById(int id) {
		// setting logger info
		logger.info("delete the address details By Id ");
		Optional<Address> address = addressRepo.findById(id);
		if (!address.isPresent()) {
			return null;
		}
		addressRepo.delete(address.get());
		return address.get();
	}
}