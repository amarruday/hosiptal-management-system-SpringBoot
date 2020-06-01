package com.has.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles
{
	private int roleId;
	private String roleName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	public int getRoleId()
	{
		return roleId;
	}

	@Column(name = "role_name")
	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleId(int roleId)
	{
		this.roleId = roleId;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

}
