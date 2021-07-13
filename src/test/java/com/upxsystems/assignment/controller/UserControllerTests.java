package com.upxsystems.assignment.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.upxsystems.assignment.entity.User;
import com.upxsystems.assignment.service.UserService;

@SpringBootTest(classes=com.upxsystems.assignment.config.AssignmentApplication.class)
@AutoConfigureMockMvc
public class UserControllerTests {	

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService service;

	/*** Start of Test cases for controllers ***/

	@Test
	public void retrieveUsers_unauthorised() throws Exception {
		mvc.perform(get("/user/list").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isUnauthorized());
	}

	@Test
	@WithMockUser(roles = "FORBIDDEN")
	public void retrieveUsers_forbidden() throws Exception {
		mvc.perform(get("/user/list").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isForbidden());
	}

	@Test
	@WithMockUser(roles = "USER")
	public void retrieveUsers_success() throws Exception {
		mvc.perform(get("/user/list").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void createUser_unauthorized() throws Exception {
		mvc.perform(post("/user/create").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isUnauthorized());
	}

	@Test
	@WithMockUser(roles = "FORBIDDEN")
	public void createUser_forbidden() throws Exception {
		mvc.perform(post("/user/create").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isForbidden());
	}

	@Test
	@WithMockUser(roles = "MANAGER")
	public void createUser() throws Exception {

		User newUser = new User();
		newUser.setUsername("James");
		newUser.setPassword("Pass");
		newUser.setStatus("Activated");

		when(service.saveUser(newUser)).thenReturn(newUser);
		mvc.perform(post("/user/create").content("{\n" + "	\"username\": \"James\",\n" + "	\"password\": \"Pass\",\n"
				+ "	\"status\": \"Activated\"\n" + "}").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void updateUser_unauthorized() throws Exception {
		mvc.perform(put("/user/update").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isUnauthorized());
	}
	
	/*
	 * @Test
	 * 
	 * @WithMockUser(roles = "FORBIDDEN") public void updateUser_forbidden() throws
	 * Exception {
	 * mvc.perform(put("/user/update").contentType(MediaType.APPLICATION_JSON)).
	 * andExpect(status().isForbidden()); }
	 */
	
	@Test
	@WithMockUser(roles = "MANAGER")
	public void updateUser() throws Exception {
		User anubhuti = new User();
		anubhuti.setUsername("Anubhuti");
		anubhuti.setPassword("AllIsWell@2021");
		anubhuti.setStatus("Activated");

		when(service.updateUser(anubhuti)).thenReturn(anubhuti);

		mvc.perform(put("/user/update")
				.content("{\"username\": \"Jef\",\"password\": \"JustDoIt\",\"status\": \"Activated\"}")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	@WithMockUser(roles = "MANAGER")
	public void updateUser_badRequest() throws Exception {
		mvc.perform(put("/user/update").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}
	
	@Test
	public void deleteUser_unauthorized() throws Exception {
		mvc.perform(delete("/user/delete").param("userId", "0").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnauthorized());
	}
	
	@Test
	@WithMockUser(roles = "FORBIDDEN")
	public void deleteUser_forbidden() throws Exception {
		mvc.perform(delete("/user/delete").param("userId", "0").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isForbidden());
	}

	@Test
	@WithMockUser(roles = "MANAGER")
	public void deleteUser() throws Exception {
		mvc.perform(delete("/user/delete").param("userId", "0").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}}
