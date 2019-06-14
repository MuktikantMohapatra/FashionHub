package com.fashionhub.register.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fashionhub.register.util.entity.ConfirmationToken;

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
	@Column(name = "ENABLED")
	private boolean isEnabled;
	@ManyToMany
	@JoinTable(name = ("USER_ROLE"), joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<RoleEntity> roles;
	@ManyToMany
	@JoinTable(name = ("USER_ADDRESS"), joinColumns = @JoinColumn(name = "ADDRESS_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID"))
	private Set<AddressEntity> address;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private ConfirmationToken token;

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

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
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

	public ConfirmationToken getToken() {
		return token;
	}

	public void setToken(ConfirmationToken token) {
		if (this.token != null) {
			this.token.setUser(null);
		}
		this.token = token;
	}

	@Override
	public String toString() {
		return "UserEntity [name=" + name + ", phone=" + phone + ", email=" + email + ", dob=" + dob + ", gender="
				+ gender + ", password=" + password + ", roles=" + roles + ", address=" + address + "]";
	}

}
