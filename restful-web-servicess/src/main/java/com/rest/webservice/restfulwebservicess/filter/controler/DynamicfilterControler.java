package com.rest.webservice.restfulwebservicess.filter.controler;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rest.webservice.restfulwebservicess.filter.model.DynamicFilterCustomer;
import com.rest.webservice.restfulwebservicess.filter.service.DynamicFilterService;

@RestController
public class DynamicfilterControler {

	@Autowired
	DynamicFilterService dynamicFilterService;

	@GetMapping("/dynamicfiltering")

	public MappingJacksonValue customerdy() {

		DynamicFilterCustomer customer = new DynamicFilterCustomer(1, "Amit", "kumar", "Das", 5289);

		return dynamicFilterService.mappingJacksonValue(customer);

	}

	@GetMapping("/dynamicfilteringlist")

	public MappingJacksonValue customerlistdy() {

		List<DynamicFilterCustomer> customers = Arrays.asList(
				new DynamicFilterCustomer(1, "Amit", "kumar", "Das", 5289),
				new DynamicFilterCustomer(2, "Rabi", "Chandra", "Asuin", 5289));

		return dynamicFilterService.mappingJacksonValues(customers);

	}

}
