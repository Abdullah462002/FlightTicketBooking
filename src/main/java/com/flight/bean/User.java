package com.flight.bean;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class User {
	@NotBlank(message = " *Name is Mandatory")
	private String name;
	@NotBlank(message = " *Password is Mandatory")
	private String password;
	
	private String role;
	public String getRole() {
		return role;
	}
	public void setRoles(String role) {
		this.role = role;
	}
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public User() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
