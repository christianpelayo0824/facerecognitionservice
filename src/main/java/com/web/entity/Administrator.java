package com.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administrator", catalog = "central_db")
public class Administrator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String firstname;
	private String lastname;
	private String password;
	private String email;
	private String role;

	public String getRole() {
		return role;
	}

	public Administrator setRole(String role) {
		this.role = role;
		return this;
	}

	public int getAid() {
		return aid;
	}

	public Administrator setAid(int aid) {
		this.aid = aid;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public Administrator setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public Administrator setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Administrator setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Administrator setEmail(String email) {
		this.email = email;
		return this;
	}

	@Override
	public String toString() {
		return "Administrator [aid=" + aid + ", firstname=" + firstname + ", lastname=" + lastname + ", password="
				+ password + ", email=" + email + ", role=" + role + "]";
	}

}
