package com.flight.bean;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDetails {
	private String cId;
	@NotBlank(message = " *Name is Mandatory")
	@Pattern(message="Only alphabets",regexp="[A-Za-z]*")
	private String name;
	@NotBlank(message = " *Email is Mandatory")
	private String email;
	@NotBlank(message = " *Password is Mandatory")
	@Size(min=5,max=10,message="minimum 5 letter maximum 10 letter")
	@Pattern(message="must have atleast one special",regexp="^(?=.*[A-Za-z0-9])(?=.*[!@#$%^&*]).{8,}$")
	private String password;
	@NotBlank(message = " *Password is Mandatory")
	@Pattern(message="must have atleast one special",regexp="^(?=.*[A-Za-z0-9])(?=.*[!@#$%^&*]).{8,}$")
	private String reTypePassword;
	@NotBlank(message = " *DOB is Mandatory")
	private String dateOfBirth;
	@NotBlank(message = " *Address is Mandatory")
	private String address;
	@NotBlank(message = " *Gender is Mandatory")
	private String gender;
	@NotBlank(message = " *Phone No. is Mandatory")
	private String phone;
	@NotBlank(message = " *SSN Type is Mandatory")
	private String ssnType;
	@Min(message="Greater than 100", value=100)
	private int ssnNumber;
	public String getcId() {
		return cId;
	}
	public UserDetails() {
		super();
	}
	public UserDetails(String cId, String name, String email, String password, String reTypePassword,
			String dateOfBirth, String address, String gender, String phone, String sSNType, int sSNNumber) {
		super();
		this.cId = cId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.reTypePassword = reTypePassword;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.gender = gender;
		this.phone = phone;
		this.ssnType = sSNType;
		this.ssnNumber = sSNNumber;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReTypePassword() {
		return reTypePassword;
	}
	public void setReTypePassword(String reTypePassword) {
		this.reTypePassword = reTypePassword;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSSNType() {
		return ssnType;
	}
	public void setSSNType(String ssnType) {
		this.ssnType = ssnType;
	}
	public int getSSNNumber() {
		return ssnNumber;
	}
	public void setSSNNumber(int ssnNumber) {
		this.ssnNumber = ssnNumber;
	}
	@Override
	public String toString() {
		return "UserDetails [cId=" + cId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", reTypePassword=" + reTypePassword + ", dateOfBirth=" + dateOfBirth + ", address=" + address
				+ ", gender=" + gender + ", phone=" + phone + ", ssnType=" + ssnType + ", ssnNumber=" + ssnNumber + "]";
	}
	
}
