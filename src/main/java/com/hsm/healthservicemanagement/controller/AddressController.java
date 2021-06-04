package com.hsm.healthservicemanagement.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.Address;
import com.hsm.healthservicemanagement.exception.AddressNotFoundException;
import com.hsm.healthservicemanagement.service.IAddressService;

@RestController
public class AddressController {

	// Logger Declare
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(AddressController.class);

	// We use @Autowired the address service layer to this controller layer of
	// address
	@Autowired
	IAddressService addressService;

	// This controller is used to create a new or add new address and redirects it
	// to the service layer.
	// save address
	@PostMapping("/address")
	public Address save(@RequestBody Address address) {
		// setting logger info
		logger.info("save the details of the address");
		return addressService.save(address);
	}

	// This controller is used to return and list all the address found in the
	// database and request to the service to perform the action.
	// find/viewAllAddressDetails

	@GetMapping("/address")
	public List<Address> findAllAddresses() {
		// setting logger info
		logger.info("Find the details of the address");

		return addressService.findAllAddresses();
	}

	// This controller is used to get a specific address on basis of ID.
	// findById

	@GetMapping("/address/id/{id}")
	public Address findAddressById(@PathVariable("id") int id) {
		// setting logger info
		logger.info("Get the address details By Id");

		if (addressService.findAddressById(id) == null) {
			throw new AddressNotFoundException("Address not found with given id: " + id);
		}
		return addressService.findAddressById(id);
	}

	// This controller function perform deletion of a specific given address
	// and request the service to perform the action and return the message as
	// deleted else throw exception
	// deleteById

	@DeleteMapping("/address/{id}")
	public Address deleteAddressById(@PathVariable("id") int id) {
		// setting logger info
		logger.info(" delete the address By Id");

		if (addressService.deleteAddressById(id) == null) {
			throw new AddressNotFoundException("Address not found with given id: " + id);
		}
		return addressService.deleteAddressById(id);
	}

}