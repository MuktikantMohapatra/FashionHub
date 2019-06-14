package com.fashionhub.register.dto;

import java.sql.Date;

public class UserDto {
	private String id;
	private String name;
	private long phone;
	private String email;
	private Date dob;
	private String gender;
	private String password;
	private String isEnabled;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", dob=" + dob
				+ ", gender=" + gender + ", password=" + password + "]";
	}

}
