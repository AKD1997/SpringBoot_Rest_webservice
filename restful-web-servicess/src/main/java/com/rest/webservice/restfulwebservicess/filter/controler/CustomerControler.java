package com.rest.webservice.restfulwebservicess.filter.controler;

import com.rest.webservice.restfulwebservicess.filter.model.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerControler {

	@GetMapping("/customer")
	public Customer customer() {
		return new Customer(1, "Amit", "kumar", "Das", 5289);

	}

	@GetMapping("/customerlist")
	public List<Customer> customerlist() {
		return new ArrayList<Customer>(Arrays.asList(new Customer(1, "Amit", "kumar", "Das", 5289),
				new Customer(1, "Rahul", "kumar", "Das", 5289)));

	}
}
