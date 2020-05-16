package com.rest.webservice.restfulwebservicess.filter.service;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rest.webservice.restfulwebservicess.filter.model.DynamicFilterCustomer;

@Service
public class DynamicFilterService {

	public MappingJacksonValue mappingJacksonValues(List<DynamicFilterCustomer> customer) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("firstname", "id");
		FilterProvider filters = new SimpleFilterProvider().addFilter("customerfilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(customer);
		mapping.setFilters(filters);
		return mapping;
	}

	public MappingJacksonValue mappingJacksonValue(DynamicFilterCustomer customer) {

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("secondname", "id");
		FilterProvider filters = new SimpleFilterProvider().addFilter("customerfilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(customer);
		mapping.setFilters(filters);
		return mapping;

	}
}
