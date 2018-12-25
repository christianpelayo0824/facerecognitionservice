package com.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.entity.LoginEmployee;

@Repository
public interface LoginEmployeeRepository extends JpaRepository<LoginEmployee, Integer> {

	@Query(value = "SELECT * FROM employee t1 JOIN job_description t2"
			+ " ON t1.e_id = t2.id JOIN login_face t3"
			+ " ON t2.employee_id = t3.employee_id"
			+ " WHERE t3.employee_id = :employeeId",
			nativeQuery = true)
	public Optional<LoginEmployee> getLoginEmployeeByCostomId(@Param("employeeId") final int employeeId);
}
