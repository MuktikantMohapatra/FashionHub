package com.fashionhub.register.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "USER_DETAILS")
public class UserEntity extends AbstractEntity {
	@Column
	private String name;
	@Column
	private long phone;
	@Column
	private String email;
	@Column
	private Date dob;
	@Column
	private String gender;
	@Column
	private String password;
	@ManyToMany
	@JoinTable(name = ("USER_ROLE"), joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<RoleEntity> roles;
	@ManyToMany
	@JoinTable(name = ("USER_ADDRESS"), joinColumns = @JoinColumn(name =  "ADDRESS_ID"), inverseJoinColumns = @JoinColumn(name ="USER_ID"))
	private Set<AddressEntity> address;

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

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

	public Set<AddressEntity> getAddress() {
		return address;
	}

	public void setAddress(Set<AddressEntity> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserEntity [name=" + name + ", phone=" + phone + ", email=" + email + ", dob=" + dob + ", gender="
				+ gender + ", password=" + password + ", roles=" + roles + ", address=" + address + "]";
	}

}
