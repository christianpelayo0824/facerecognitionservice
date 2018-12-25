package com.web.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.web" })
@EnableJpaRepositories(basePackages = { "com.web.repository" })
@EntityScan(basePackages = { "com.web.entity" })
public class FacerecognitionserviceApplication implements CommandLineRunner {

	// @Autowired
	// private EmployeeCareerProfileService empCareerProfileService;
	//
	// @Autowired
	// private LoginEmployeeRepository loginFaceRepo;
	//
	// @Autowired
	// private EmployeeCareerProfileRepository employeeCareerProfileRepo;

	public static void main(String[] args) {
		SpringApplication.run(FacerecognitionserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//
		// EmployeePersonalInfo empInfo = new EmployeePersonalInfo();
		// empInfo.setFirstname("Christian").setLastname("Pelayo").setPhone(12345678901L).setEmail("chan@gmail.com");
		// EmployeeCareerProfile empCareerProfile = new EmployeeCareerProfile();
		// empCareerProfile.setDepartment("COE").setPosition("CEO").setStation("A").setEmployee_id(12345678)
		// .setEmployee(empInfo);
		//
		// EmployeePersonalInfo empInfo2 = new EmployeePersonalInfo();
		// empInfo2.setFirstname("Kyra").setLastname("Pelayo").setPhone(12345678901L).setEmail("chan@gmail.com");
		// EmployeeCareerProfile empCareerProfile2 = new EmployeeCareerProfile();
		// empCareerProfile2.setDepartment("COE").setPosition("CEO").setStation("A").setEmployee_id(12345677)
		// .setEmployee(empInfo2);
		//
		// empCareerProfileService.createCareerProfile(empCareerProfile2);
		// empCareerProfileService.createCareerProfile(empCareerProfile);

		// dd-MMM-yy hh.mm.ss.S aa
		// DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy
		// hh:mm:ss a");

		// LoginEmployee loginFace = new LoginEmployee();
		// loginFace.setDateTime(LocalDateTime.now()).setEmployeeId(12345678);
		// loginFaceRepo.save(loginFace);
		//
		// LoginEmployee loginFace2 = new LoginEmployee();
		// loginFace2.setDateTime(LocalDateTime.now()).setEmployeeId(12345677);
		// loginFaceRepo.save(loginFace2);
		//
		// LoginEmployee loginFace3 = new LoginEmployee();
		// loginFace3.setDateTime(LocalDateTime.now()).setEmployeeId(12345677);
		// loginFaceRepo.save(loginFace3);
		//
		// LoginEmployee loginFace4 = new LoginEmployee();
		// loginFace4.setDateTime(LocalDateTime.now()).setEmployeeId(12345677);
		// loginFaceRepo.save(loginFace4);

		// System.out.println(loginFaceRepo.getLoginEmployeeByCostomId(12345678));

	}

}
