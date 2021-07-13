package com.upxsystems.assignment.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upxsystems.assignment.entity.User;

/**
 * UserDAO is Data access layer. Establishes connection with the DB and uses
 * basic CrudRepository exposed methods - findAll, deletebyId, save for
 * retrieving, deleting, creating and updating users
 */
@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
}
