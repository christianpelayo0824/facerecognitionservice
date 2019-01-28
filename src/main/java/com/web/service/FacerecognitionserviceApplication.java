package com.web.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.web.entity.Reason;
import com.web.repository.EmployeeCareerProfileRepository;
import com.web.repository.ReasonRepository;
import com.web.services.EmployeeCareerProfileService;
import com.web.services.LoginEmployeeService;

@SpringBootApplication(scanBasePackages = { "com.web" })
@EnableJpaRepositories(basePackages = { "com.web.repository" })
@EntityScan(basePackages = { "com.web.entity" })
public class FacerecognitionserviceApplication implements CommandLineRunner {

	@Autowired
	private EmployeeCareerProfileService empCareerProfileService;

	@Autowired
	EmployeeCareerProfileRepository empCareerRepo;

	@Autowired
	LoginEmployeeService loginEmployeeService;

	@Autowired
	ReasonRepository reasonRepo;
	/*
	 * @Autowired private LogoutEmployeeRepository logoutEmployeeRepo;
	 * 
	 * @Autowired private LoginEmployeeRepository loginEmployeeRepo;
	 */

	static Logger logger = LoggerFactory.getLogger(FacerecognitionserviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FacerecognitionserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Reason reason = new Reason();
		//
		// if (loginEmployeeService.getEmpLoginDateTimeById(12345678).getDayOfMonth() ==
		// LocalDateTime.now()
		// .getDayOfMonth()) {
		// if ((LocalDateTime.now().getHour()
		// - loginEmployeeService.getEmpLoginDateTimeById(12345678).getHour()) <= 8) {
		// reason.setEmployeeId(12345678).setReason("Test Test
		// Test..").setLocalDateTime(LocalDateTime.now());
		// reasonRepo.save(reason);
		// System.out.println("HIT");
		//
		// }
		// }

	}

}
