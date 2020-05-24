package com.rest.webservice.restfulwebservicess.versioning.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservice.restfulwebservicess.versioning.model.Name;
import com.rest.webservice.restfulwebservicess.versioning.model.PersonV1;
import com.rest.webservice.restfulwebservicess.versioning.model.PersonV2;

@RestController
public class PersonVersioningControler {

	@GetMapping("v1/person")
	public PersonV1 persionv1() {
		return new PersonV1("Bob rahul");
	}

	@GetMapping("v2/person")
	public PersonV2 persionv2() {
		return new PersonV2(new Name("Bob", "rahul"));

	}

	@GetMapping(value = "/person/paramv1", params = "version=2")
	public PersonV1 paramv1() {
		return new PersonV1("Bob rahul");
	}

	@GetMapping(value = "/person/paramv2", params = "version=2")
	public PersonV2 paramv2() {
		return new PersonV2(new Name("Bob", "rahul"));

	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerv1() {
		return new PersonV1("Bob rahul");
	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerv2() {
		return new PersonV2(new Name("Bob", "rahul"));

	}

	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesv1() {
		return new PersonV1("Bob rahul");
	}

	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesv2() {
		return new PersonV2(new Name("Bob", "rahul"));

	}
}