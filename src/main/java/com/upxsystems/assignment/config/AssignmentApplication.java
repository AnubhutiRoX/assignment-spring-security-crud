package com.upxsystems.assignment.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.upxsystems.assignment.controller", "com.upxsystems.assignment.service",
		"com.upxsystems.assignment.security" })
@EnableJpaRepositories(basePackages = { "com.upxsystems.assignment.dao" })
@EntityScan(basePackages = { "com.upxsystems.assignment.entity" })
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

}
