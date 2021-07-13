package com.upxsystems.assignment.service;

import org.springframework.stereotype.Component;

import com.upxsystems.assignment.entity.User;

/**
 * UserService is the class meant for UserController to interact with persistence
 * layer UserDAO.
 * 
 */
@Component
public interface UserService {
	/**
	 * getUsers method is used to delegate the retrieval of all users to userDAO
	 * 
	 * @return list of User objects
	 */
	public Iterable<User> getUsers();

	/**
	 * saveUser method is used to delegate the creation of new user to userDAO
	 * 
	 * @param user pojo without id
	 * @return saved User object
	 */
	public User saveUser(User user);

	/**
	 * updateUser method is used to delegate the updation of the user to userDAO
	 * 
	 * @param user pojo with id
	 * @return updated User object
	 */
	public User updateUser(User user);

	/**
	 * deleteUser method is used to delegate the deletion of the user to userDAO It
	 * checks if the user exists in the DB before deletion.
	 * 
	 * @param id is user id
	 * @return boolean to identify successful/unsuccessful deletion operation
	 */
	public boolean deleteUser(int id);
}
