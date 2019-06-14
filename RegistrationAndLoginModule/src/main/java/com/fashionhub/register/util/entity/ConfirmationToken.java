package com.fashionhub.register.util.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import com.fashionhub.register.entity.UserEntity;

@Entity
public class ConfirmationToken {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	@Column(name = "confirmation_token")
	private String confirmationToken;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@OneToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "USER_ID")
	private UserEntity user;

	public ConfirmationToken() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public ConfirmationToken(UserEntity user) {
		System.out.println("ConfirmationToken.ConfirmationToken()");
		this.user = user;
		createdDate = new Date();
		confirmationToken = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ConfirmationToken [id=" + id + ", confirmationToken=" + confirmationToken + ", createdDate="
				+ createdDate + ", user=" + user + "]";
	}

}
