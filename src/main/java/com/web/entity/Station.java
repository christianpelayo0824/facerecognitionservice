package com.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "station", catalog = "central_db")
public class Station {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int employeeId;

	private String station;

	@OneToOne()
	@JoinColumn(name = "employeeId", referencedColumnName = "employee_id", insertable = false, updatable = false)
	private EmployeeCareerProfile empCareerProfile;

	public int getId() {
		return id;
	}

	public Station setId(int id) {
		this.id = id;
		return this;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public Station setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	public String getStation() {
		return station;
	}

	public Station setStation(String station) {
		this.station = station;
		return this;
	}

	public EmployeeCareerProfile getEmpCareerProfile() {
		return empCareerProfile;
	}

	public Station setEmpCareerProfile(EmployeeCareerProfile empCareerProfile) {
		this.empCareerProfile = empCareerProfile;
		return this;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", employeeId=" + employeeId + ", station=" + station + ", empCareerProfile="
				+ empCareerProfile + "]";
	}

}
