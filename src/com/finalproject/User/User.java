package com.finalproject.User;

import java.util.*;
import org.codehaus.jackson.annotate.*;

import com.finalproject.Role.Role;
public class User {
	private int userId;
	private String username;
	private String password; 
	private String token;
	private List<Role> roles;
	private String created_at;
	private String updated_at;
	
	public User() {}
	public User(int userId, String username, String password, String token, List<Role> roles, String created_at, String updated_at) {
		this.setUserId(userId);
		this.setUsername(username);
		this.setPassword(password);
		this.setRoles(roles);
		this.setToken(token);
		this.setCreated_at(created_at);
		this.setUpdated_at(updated_at);
	}
	/**
	 * @return the userId
	 */

	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the password
	 */

	@JsonIgnore
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
}
