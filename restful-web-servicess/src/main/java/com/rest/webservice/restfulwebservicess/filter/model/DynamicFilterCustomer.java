package com.rest.webservice.restfulwebservicess.filter.model;
import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("customerfilter")
public class DynamicFilterCustomer {

	private Integer id;
	private String firstname;
	private String secondname;
	private String familyname;
	private Integer password;

	public DynamicFilterCustomer(Integer id, String firstname, String secondname, String familyname, Integer password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.secondname = secondname;
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
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
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
		return "Customer [id=" + id + ", firstname=" + firstname + ", secondname=" + secondname + ", familyname="
				+ familyname + ", password=" + password + "]";
	}

}
