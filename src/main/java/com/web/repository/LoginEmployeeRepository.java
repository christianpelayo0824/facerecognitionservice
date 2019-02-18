package com.web.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.entity.LoginEmployee;

@Repository
public interface LoginEmployeeRepository extends JpaRepository<LoginEmployee, Integer> {
	
	@Query(value = "SELECT COUNT(*) FROM employee t1 JOIN job_description t2 ON "
			+ "t1.e_id = t2.id JOIN login_employee t3 ON t2.employee_id = t3.employee_id "
			+ "WHERE t3.physical_station = :station", nativeQuery = true)
	int countAllLoginEmployeeByStation(@Param("station") final String station);
	
	
	/*
	 * Native Query for getting relation of the table employee, job_description if
	 * they are relation with the active login employee_id in table login_face.
	 */	 
	@Query(value = "SELECT * FROM employee t1 JOIN job_description t2"
			+ " ON t1.e_id = t2.id JOIN login_employee t3"
			+ " ON t2.employee_id = t3.employee_id"
			+ " WHERE t3.employee_id = :employeeId",
			nativeQuery = true)
	public Optional<LoginEmployee> getLoginEmployeeByCostomId(
				@Param("employeeId") final int employeeId
			);
	
	@Transactional
	public List<LoginEmployee> findByPhysicalStation(String physicalStation);
	
	
	@Query(value="SELECT MAX(date_time) FROM login_employee "
			+ "WHERE employee_id = :employeeId", 
			nativeQuery = true)
	public LocalDateTime getEmpLoginDateTimeById(
				@Param("employeeId") final int employeeId
			);

	/*
	 * JPA transaction in getting employee_id using primary id
	 */ 
	@Transactional
	public void deleteByEmployeeId(int employeeId);
	
	
	

	
	
	
	
	
	
}
