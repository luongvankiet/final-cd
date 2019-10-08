package com.finalproject.Role;

public class Role {
	private int roleId;
	private String name;
	private String created_at;
	private String updated_at;
	public Role() {}
	public Role(int roleId, String name, String created_at, String updated_at) {
		this.setRoleId(roleId);
		this.setName(name);
		this.setCreated_at(created_at);
		this.setUpdated_at(updated_at);
	}
	/**
	 * @return the roleID
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleID the roleID to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
