package com.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee", catalog = "central_db")
public class EmployeePersonalInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "e_id")
	private Integer e_id;

	@Column(name = "firstname")
	@Size(max = 30)
	private String firstname;

	@Column(name = "lastname")
	@Size(max = 30)
	private String lastname;

	@Column(name = "phone")
	private Integer phone;

	@Column(name = "email")
	@Size(max = 30)
	private String email;

	public Integer getE_id() {
		return e_id;
	}

	public EmployeePersonalInfo setE_id(Integer e_id) {
		this.e_id = e_id;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public EmployeePersonalInfo setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public EmployeePersonalInfo setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public Integer getPhone() {
		return phone;
	}

	public EmployeePersonalInfo setPhone(Integer phone) {
		this.phone = phone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public EmployeePersonalInfo setEmail(String email) {
		this.email = email;
		return this;
	}

	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone
				+ ", email=" + email + "]";
	}

}
