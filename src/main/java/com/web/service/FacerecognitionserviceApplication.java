package com.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.web.services.EmployeeCareerProfileService;

@SpringBootApplication(scanBasePackages = { "com.web" })
@EnableJpaRepositories(basePackages = { "com.web.repository" })
@EntityScan(basePackages = { "com.web.entity" })
public class FacerecognitionserviceApplication implements CommandLineRunner {

	// @Autowired
	// private EmployeeCareerProfileService empCareerProfileService;

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
		// System.out.println(empCareerProfileService.getDistinctStation());
	}

}
