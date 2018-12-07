package com.web.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "job_description", catalog = "central_db")
public class EmployeeCareerProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "department")
	@Size(max = 30)
	private String department;

	@Column(name = "position")
	@Size(max = 30)
	private String position;

	@Column(name = "station")
	@Size(max = 30)
	private String station;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private EmployeePersonalInfo employee;

	public Integer getId() {
		return id;
	}

	public EmployeeCareerProfile setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getDepartment() {
		return department;
	}

	public EmployeeCareerProfile setDepartment(String department) {
		this.department = department;
		return this;
	}

	public String getPosition() {
		return position;
	}

	public EmployeeCareerProfile setPosition(String position) {
		this.position = position;
		return this;
	}

	public String getStation() {
		return station;
	}

	public EmployeeCareerProfile setStation(String station) {
		this.station = station;
		return this;
	}

	public EmployeePersonalInfo getEmployee() {
		return employee;
	}

	public EmployeeCareerProfile setEmployee(EmployeePersonalInfo employee) {
		this.employee = employee;
		return this;
	}

	@Override
	public String toString() {
		return "JobProfile [id=" + id + ", department=" + department + ", position=" + position + ", station=" + station
				+ ", employee=" + employee + "]";
	}

}
