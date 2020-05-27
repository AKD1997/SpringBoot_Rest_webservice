package com.rest.webservice.restfulwebservicess.User.Service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservice.restfulwebservicess.User.model.User;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
