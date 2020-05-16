package com.rest.webservice.restfulwebservicess.filter.controler;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservice.restfulwebservicess.filter.model.Customer;

@RestController
public class CustomerControler {

	@GetMapping("/staticfilter")
	public Customer customer() {
		return new Customer(1, "Amit", "kumar", "Das", 5289);

	}

	@GetMapping("/staticlistfilter")
	public List<Customer> customerlist() {
		return Arrays.asList(new Customer(1, "Amit", "kumar", "Das", 5289),
				new Customer(1, "Rahul", "kumar", "Das", 5289));

	}
}