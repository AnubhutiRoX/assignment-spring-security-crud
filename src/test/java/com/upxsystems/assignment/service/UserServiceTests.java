package com.upxsystems.assignment.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.upxsystems.assignment.dao.UserDAO;
import com.upxsystems.assignment.entity.User;

@SpringBootTest(classes=com.upxsystems.assignment.config.AssignmentApplication.class)
@AutoConfigureMockMvc
public class UserServiceTests {
	@TestConfiguration
	static class UserServiceImplTestContextConfiguration {

		@Bean
		public UserService userService() {
			return new UserServiceImpl();
		}
	}

	@Autowired
	private UserService userService;

	@MockBean
	private UserDAO userRepository;

	@Test
	public void retrieveUsers() {
		User anubhuti = new User();
		anubhuti.setId(0);
		anubhuti.setUsername("Anubhuti");
		anubhuti.setPassword("Pass");
		anubhuti.setStatus("Activated");

		User dona = new User();
		dona.setId(1);
		dona.setUsername("Dona");
		dona.setPassword("Pass");
		dona.setStatus("Deactivated");

		List<User> users = new ArrayList<>();
		users.add(anubhuti);
		users.add(dona);

		Mockito.when(userRepository.findAll()).thenReturn(users);

		// list
		String name = "Anubhuti";
		Iterable<User> found = userService.getUsers();

		assert (found.iterator().next().getUsername()).contentEquals(name);
	}
	
	@Test
	public void create() {
		User anubhuti = new User();
		anubhuti.setId(0);
		anubhuti.setUsername("Anubhuti");
		anubhuti.setPassword("Pass");
		anubhuti.setStatus("Activated");

		// create
		Mockito.when(userRepository.save(anubhuti)).thenReturn(anubhuti);
		User newUser = userService.saveUser(anubhuti);
		
		assert (newUser.getUsername()).contentEquals("Anubhuti");
	}
	
	@Test
	public void updateUser() {
		User anubhuti = new User();
		anubhuti.setId(0);
		anubhuti.setUsername("Anubhuti");
		anubhuti.setPassword("Pass");
		anubhuti.setStatus("Activated");

		User dona = new User();
		dona.setId(1);
		dona.setUsername("Dona");
		dona.setPassword("Pass");
		dona.setStatus("Deactivated");

		List<User> users = new ArrayList<>();
		users.add(anubhuti);
		users.add(dona);

		Mockito.when(userRepository.findAll()).thenReturn(users);
		Iterable<User> allusers = userService.getUsers();

		// update
		anubhuti.setPassword("Pass12");
		Mockito.when(userRepository.save(anubhuti)).thenReturn(anubhuti);
		userService.saveUser(anubhuti);

		assert (allusers.iterator().next().getPassword()).contentEquals("Pass12");
	}
	
	@Test
	public void deleteUser() {
		assertTrue(userService.deleteUser(0));
	}
}