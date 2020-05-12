package com.rest.webservice.restfulwebservicess.User.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservice.restfulwebservicess.User.Service.UserService;
import com.rest.webservice.restfulwebservicess.User.model.User;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		List<User> user = service.FindAll();
		if (user == null) {
			throw new UserNotFoundException("User" + user);
		}
		return user;
	}

	@GetMapping("/users/{id}")
	public Resource<User> retriveuser(@PathVariable int id) {
		User user = service.findOne(id);
		if (user == null)
			throw new UserNotFoundException("Id-" + id);
		Resource<User> resourses = new Resource<User>(user);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retriveAllUsers());
		resourses.add(linkTo.withRel("all-users"));
		return resourses;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createusers(@Valid @RequestBody User user) {
		User saveuser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveuser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public User deleteUsers(@Valid @PathVariable int id) {
		User user = service.DeleteByID(id);
		if (user == null) {
			throw new UserNotFoundException("Id-" + id);
		}
		return user;
	}
}
