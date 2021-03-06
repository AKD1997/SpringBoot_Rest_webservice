package com.rest.webservice.restfulwebservicess.User.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "HERE WE CAN SEE THE USER DETAILS ")
@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min = 4, message = "Name Should have at list 4 Character")
	@ApiModelProperty(notes = "Name Should have at list 4 Character")
	private String name;
	
	@OneToMany(mappedBy = "user")
	private List<Post>post;

	@Past(message = "BirthDay always Past")
	@ApiModelProperty(notes = "Birth date should be in the past")
	private Date bdayDate;

	public User(Integer id, String name, Date bdayDate) {
		super();
		this.id = id;
		this.name = name;
		this.bdayDate = bdayDate;
	}

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBdayDate() {
		return bdayDate;
	}

	public void setBdayDate(Date bdayDate) {
		this.bdayDate = bdayDate;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", bdayDate=" + bdayDate + "]";
	}

}
