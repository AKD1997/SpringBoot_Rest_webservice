package com.rest.webservice.restfulwebservicess.User.model;

import java.util.Date;

public class User {
	private Integer id;
	private String name;
	private Date bdayDate;

	public User(Integer id, String name, Date bdayDate) {
		super();
		this.id = id;
		this.name = name;
		this.bdayDate = bdayDate;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", bdayDate=" + bdayDate + "]";
	}

}
