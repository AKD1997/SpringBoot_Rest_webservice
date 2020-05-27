package com.rest.webservice.restfulwebservicess.User.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.rest.webservice.restfulwebservicess.User.Service.UserJpaRepository;
import com.rest.webservice.restfulwebservicess.User.model.User;

@RestController
public class UserJpaController {

	@Autowired
	UserJpaRepository userJpaRepository;

	@GetMapping("/Jpa/users")
	public List<User> retriveAllUsers() {
		return userJpaRepository.findAll();
	}

	@GetMapping("/Jpa/users/{id}")
	public Resource<User> retriveuser(@PathVariable int id) {
		Optional<User> user = userJpaRepository.findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException("Id-" + id);

		Resource<User> resourses = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retriveAllUsers());
		resourses.add(linkTo.withRel("all-users"));
		return resourses;
	}

	@PostMapping("/Jpa/users")
	public ResponseEntity<Object> createusers(@Valid @RequestBody User user) {
		User saveuser = userJpaRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveuser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/Jpa/users/{id}")
	public void deleteUsers(@Valid @PathVariable int id) {
		userJpaRepository.deleteById(id);

	}
}
