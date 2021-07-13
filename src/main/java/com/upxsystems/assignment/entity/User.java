package com.upxsystems.assignment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User class is having same structure as that of DB table User so that the
 * spring can easily relate the DB table with passed User object
 */
@Entity
@Table(name = "user")
public class User implements Serializable{

	
	/**
	 * This has been added t support hazelcast
	 */
	private static final long serialVersionUID = 1037947780216557803L;

	/** id is the primary key which is auto generated
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	/**
	 * This is a unique value provided in the DB
	 * */
	@Column(name = "username")
	private String username;

	/**
	 * This is the password field for the user with id
	 * */
	@Column(name = "password")
	private String password;

	/**
	 * status field is expected to have two values - Activated / Deactivated
	 * TODO: make it enum
	 * */
	@Column(name = "status")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", status=" + status + "]";
	}
}
