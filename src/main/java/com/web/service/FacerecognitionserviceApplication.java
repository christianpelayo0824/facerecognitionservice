package com.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.web" })
@EnableJpaRepositories(basePackages = { "com.web.repository" })
@EntityScan(basePackages = { "com.web.entity" })
public class FacerecognitionserviceApplication implements CommandLineRunner {

	/*@Autowired
	private EmployeeCareerProfileService empCareerProfileService;
	
	@Autowired
	private LogoutEmployeeRepository logoutEmployeeRepo;
	
	@Autowired 
	private LoginEmployeeRepository loginEmployeeRepo;*/

	static Logger logger = LoggerFactory.getLogger(FacerecognitionserviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FacerecognitionserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*EmployeePersonalInfo empInfo = new EmployeePersonalInfo();
		empInfo.setFirstname("Christian")
			.setLastname("Pelayo")
			.setPhone(12345678901L)
			.setEmail("chan@gmail.com");
		
		EmployeeCareerProfile empCareerProfile = new EmployeeCareerProfile();
		empCareerProfile.setDepartment("COE")
			.setPosition("CEO")
			.setStation("A")
			.setEmployee_id(12345678)
			.setEmployee(empInfo);

		empCareerProfileService.createCareerProfile(empCareerProfile);*/
		
		
		// Logout
		/*LogoutEmployee logoutEmployee = new LogoutEmployee();
		logoutEmployee.setDate_time(LocalDateTime.now())
			.setEmployeeId(12345678);
		logoutEmployeeRepo.save(logoutEmployee);*/
		
		// Login
		/*LoginEmployee loginEmployee= new LoginEmployee();
		loginEmployee.setDateTime(LocalDateTime.now())
			.setEmployeeId(12345678);
		loginEmployeeRepo.save(loginEmployee);*/
		
		// logger.info("ID: " + employeeCareerProfileRepo.getEmployeeIdById(1));

	}

}
