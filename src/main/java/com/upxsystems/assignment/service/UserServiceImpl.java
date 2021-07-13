package com.upxsystems.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upxsystems.assignment.dao.UserDAO;
import com.upxsystems.assignment.entity.User;

/**
 * UserServiceImpl class is the concrete implementation class. Used to perform
 * create update get delete operation using persistence layer
 * 
 */
@Service
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	/**
	 * getUsers method is used to delegate the retrieval of all users to userDAO
	 * 
	 * @return list of User objects
	 */
	@Override
	@Transactional
	public Iterable<User> getUsers() {
		return userDao.findAll(); // delegate the call to DAO
	}

	/**
	 * saveUser method is used to delegate the creation of new user to userDAO
	 * 
	 * @param user pojo without id
	 * @return saved User object
	 */
	@Override
	@Transactional
	public User saveUser(User user) {
		return userDao.save(user);
	}

	/**
	 * updateUser method is used to delegate the updation of the user to userDAO
	 * 
	 * @param user pojo with id
	 * @return updated User object
	 */
	@Override
	@Transactional
	public User updateUser(User user) {
		return userDao.save(user);
	}

	/**
	 * deleteUser method is used to delegate the deletion of the user to userDAO It
	 * checks if the user exists in the DB before deletion.
	 * 
	 * @param id is user id
	 * @return boolean to identify successful/unsuccessful deletion operation
	 */
	@Override
	@Transactional
	public boolean deleteUser(int id) {
		if (userDao.findById(id) != null) {
			userDao.deleteById(id);
			return true;
		}
		return false;
	}

}
