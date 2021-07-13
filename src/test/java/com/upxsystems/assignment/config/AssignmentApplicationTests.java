package com.upxsystems.assignment.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.upxsystems.assignment.controller.UserController;

@SpringBootTest
@AutoConfigureMockMvc
class AssignmentApplicationTests {

	@Autowired
	UserController userController;

	@Test
	void contextLoads() {
		assertNotNull(userController);
	}
}
