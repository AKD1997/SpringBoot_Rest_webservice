package com.rest.webservice.restfulwebservicess.User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public User retriveuser(@PathVariable int id) {
		User user = service.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("Id-" + id);
		}
		return user;
	}

	@PostMapping("/users")
	public User createusers(@RequestBody User user) {
		User saveuser = service.save(user);
		return saveuser;
	}
	@DeleteMapping("/users/{id}")
	public User deleteUsers(@PathVariable int id) {
		User user=service.DeleteByID(id);
		if(user==null) {
			throw new UserNotFoundException("Id-" + id);
		}
		return user;
	}
}
