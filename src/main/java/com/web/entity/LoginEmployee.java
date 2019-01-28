package com.web.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login_employee", catalog = "central_db")
public class LoginEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "date_time")
	private LocalDateTime dateTime;

	@Column(name = "physical_station")
	private String physicalStation;

	@OneToOne()
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
	private EmployeeCareerProfile empCareerProfile;

	public EmployeeCareerProfile getEmpCareerProfile() {
		return empCareerProfile;
	}

	public void setEmpCareerProfile(EmployeeCareerProfile empCareerProfile) {
		this.empCareerProfile = empCareerProfile;
	}

	public int getId() {
		return id;
	}

	public LoginEmployee setId(int id) {
		this.id = id;
		return this;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public LoginEmployee setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public LoginEmployee setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
		return this;
	}

	public String getPhysicalStation() {
		return physicalStation;
	}

	public LoginEmployee setPhysicalStation(String physicalStation) {
		this.physicalStation = physicalStation;
		return this;
	}

	@Override
	public String toString() {
		return "LoginEmployee [id=" + id + ", employeeId=" + employeeId + ", dateTime=" + dateTime
				+ ", physicalStation=" + physicalStation + ", empCareerProfile=" + empCareerProfile + "]";
	}

}
