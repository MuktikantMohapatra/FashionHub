package com.fashionhub.register.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity(name = "ROLE")
public class RoleEntity extends AbstractEntity implements GrantedAuthority {
	@Column
	private String name;
	@ManyToMany(mappedBy = "roles")
	private Set<UserEntity> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}

	@Override
	public String getAuthority() {
		return name;
	}

}
