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
@Table(name = "logout_employee", catalog = "central_db")
public class LogoutEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "date_time")
	private LocalDateTime date_time;

	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "status")
	private String status;

	@Column(name = "physical_station")
	private String physicalStation;

	@OneToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
	private EmployeeCareerProfile employeeCareerProfile;

	public int getId() {
		return id;
	}

	public LogoutEmployee setId(int id) {
		this.id = id;
		return this;
	}

	public LocalDateTime getDate_time() {
		return date_time;
	}

	public LogoutEmployee setDate_time(LocalDateTime date_time) {
		this.date_time = date_time;
		return this;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public LogoutEmployee setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	public EmployeeCareerProfile getEmployeeCareerProfile() {
		return employeeCareerProfile;
	}

	public String getStatus() {
		return status;
	}

	public LogoutEmployee setStatus(String status) {
		this.status = status;
		return this;
	}

	public LogoutEmployee setEmployeeCareerProfile(EmployeeCareerProfile employeeCareerProfile) {
		this.employeeCareerProfile = employeeCareerProfile;
		return this;
	}

	public String getPhysicalStation() {
		return physicalStation;
	}

	public LogoutEmployee setPhysicalStation(String physicalStation) {
		this.physicalStation = physicalStation;
		return this;
	}

	@Override
	public String toString() {
		return "LogoutEmployee [id=" + id + ", date_time=" + date_time + ", employeeId=" + employeeId
				+ ", employeeCareerProfile=" + employeeCareerProfile + "]";
	}

}
