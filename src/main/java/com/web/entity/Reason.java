package com.web.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reason", catalog = "central_db")
public class Reason {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int employeeId;

	private String reason;

	private LocalDateTime localDateTime;

	@OneToOne()
	@JoinColumn(name = "employeeId", referencedColumnName = "employee_id", insertable = false, updatable = false)
	private EmployeeCareerProfile empCareerProfile;

	public int getId() {
		return id;
	}

	public Reason setId(int id) {
		this.id = id;
		return this;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public Reason setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	public String getReason() {
		return reason;
	}

	public Reason setReason(String reason) {
		this.reason = reason;
		return this;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public Reason setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
		return this;
	}

	public EmployeeCareerProfile getEmpCareerProfile() {
		return empCareerProfile;
	}

	public Reason setEmpCareerProfile(EmployeeCareerProfile empCareerProfile) {
		this.empCareerProfile = empCareerProfile;
		return this;
	}

}
