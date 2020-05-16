package com.rest.webservice.restfulwebservicess.filter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "firstname", "Secondname" })
public class Customer {
	@JsonIgnore
	private Integer id;
	private String firstname;
	private String Secondname;
	private String familyname;
	@JsonIgnore
	private Integer password;

	public Customer(Integer id, String firstname, String secondname, String familyname, Integer password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.Secondname = secondname;
		this.familyname = familyname;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return Secondname;
	}

	public void setSecondname(String secondname) {
		Secondname = secondname;
	}

	public String getFamilyname() {
		return familyname;
	}

	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", Secondname=" + Secondname + ", familyname="
				+ familyname + ", password=" + password + "]";
	}

}
