package com.rest.webservice.restfulwebservicess.User.Service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservice.restfulwebservicess.User.model.Post;

public interface PostJpaRepository extends JpaRepository<Post, Integer> {

}
