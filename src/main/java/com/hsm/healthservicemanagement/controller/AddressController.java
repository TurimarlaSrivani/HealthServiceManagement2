package com.hsm.healthservicemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsm.healthservicemanagement.entity.Address;
import com.hsm.healthservicemanagement.service.IAddressService;

@RestController
public class AddressController {

	@Autowired
	IAddressService addressService;

	@GetMapping("/address/id/{id}")
	public Address findAddressById(@PathVariable("id") int id) {
		return addressService.findAddressById(id);
	}

	@DeleteMapping("/address/{id}")
	public Address deleteAddressById(@PathVariable("id") int id) {
		return addressService.deleteAddressById(id);
	}

	@GetMapping("/address")
	public List<Address> findAllAddresses() {
		return addressService.findAllAddresses();
	}

	@PostMapping("/address")
	public Address save(@RequestBody Address address) {
		return addressService.save(address);
	}

}
