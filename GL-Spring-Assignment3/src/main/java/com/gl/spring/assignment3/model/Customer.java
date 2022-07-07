package com.gl.spring.assignment3.model;

public class Customer {
	private Integer cust_ID;
	private String firstName;
	private String lastName;
	private String email;
	
	public Customer() {}

	public Customer(Integer cust_ID, String firstName, String lastName, String email) {
		super();
		this.cust_ID = cust_ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Customer(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getCust_ID() {
		return cust_ID;
	}

	public void setCust_ID(Integer cust_ID) {
		this.cust_ID = cust_ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
