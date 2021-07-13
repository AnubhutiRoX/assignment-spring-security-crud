package com.upxsystems.assignment.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes=com.upxsystems.assignment.config.AssignmentApplication.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserDAOTests {

	@Autowired
	private UserDAO userRepository;

	@Test
	public void getAllUsersCount_integratedtest() {

		long count = userRepository.count();
		System.out.println(count);
		assertTrue(count>0);
	}

}