package com.web.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.entity.LogoutEmployee;

@Repository
public interface LogoutEmployeeRepository extends JpaRepository<LogoutEmployee, Integer> {

	
	@Query(value = "SELECT COUNT(*) FROM employee t1 JOIN job_description t2 ON "
			+ "t1.e_id = t2.id JOIN logout_employee t3 ON t2.employee_id = t3.employee_id "
			+ "WHERE t3.physical_station = :station", nativeQuery = true)
	int countAllLogoutEmployeeByStation(@Param("station") final String station);
	
	/*
	 * Native Query for getting relation of the table employee, job_description if
	 * they are relation with the active login employee_id in table login_face.
	 */	 
	@Query(value = "SELECT * FROM employee t1 JOIN job_description t2"
			+ " ON t1.e_id = t2.id JOIN logout_employee t3"
			+ " ON t2.employee_id = t3.employee_id"
			+ " WHERE t3.employee_id = :employeeId",
			nativeQuery = true)
	Optional<LogoutEmployee> getLogoutEmployeeByCostomId(@Param("employeeId") final int employeeId);

	/*
	 * Native query for getting local data time using ID
	 */	
	@Query(value="SELECT date_time FROM logout_employee "
			+ "WHERE employee_id = :employeeId", 
			nativeQuery = true)
	LocalDateTime getEmpLogoutDateTimeById(@Param("employeeId") final int employeeId);

	/*
	 * Native query for getting maximum data or latest date time
	 */
	@Query(value = "SELECT MAX(logout_employee.date_time) FROM logout_employee", 
			nativeQuery = true)
	LocalDateTime getLatestLogoutLocalDateTime();
	
	/*
	 * Native query for getting maximum data or latest logout employee
	 */
	@Query(value = "SELECT * FROM logout_employee ORDER BY ID DESC LIMIT 1", 
			nativeQuery = true)
	LogoutEmployee getLatestLogoutEmployee();

	/*
	 * JPA transaction in getting employee_id using primary id
	 */
	@Transactional
	public void deleteByEmployeeId(int employeeId);

}
