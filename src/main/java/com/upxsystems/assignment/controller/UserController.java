package com.upxsystems.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.upxsystems.assignment.entity.User;
import com.upxsystems.assignment.service.UserService;

/**
 * UserController is the class for handling incoming HTTPRequests
 * 
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * listUsers method retrieves all the users from DB
	 * 
	 * @return list of users in json format
	 * 
	 */
	@GetMapping("/list")
	public @ResponseBody Iterable<User> listUsers() {
		return userService.getUsers();
	}

	/**
	 * saveUser method creates a new entry in DB
	 * 
	 * @param user object having username, password and status fields
	 * @return newly created user
	 * 
	 */
	@PostMapping("/create")
	public @ResponseBody User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	/**
	 * updateUser method updates the whole user in DB
	 * 
	 * @param user object having username, password and status fields
	 * @return updated user
	 * 
	 */
	@PutMapping("/update")
	public @ResponseBody User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	/**
	 * deleteUser method deletes the user from DB
	 * 
	 * @param userId
	 * @return success message after success full removal
	 * 
	 */
	@DeleteMapping("/delete")
	public @ResponseBody String deleteUser(@RequestParam("userId") int id) {
		if (userService.deleteUser(id)) {
			return "Deleted";
		}
		return "Please provide valid Id";
	}
	
}
