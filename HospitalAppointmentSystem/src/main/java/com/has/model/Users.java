package com.has.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="users")
public class Users
{
	private int userId;
	private Roles role;
	private String username;
	private String password;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	public int getUserId()
	{
		return userId;
	}
	
	@JoinColumn(name="role_id")
	@ManyToOne(targetEntity = Roles.class)
	public Roles getRole()
	{
		return role;
	}
	
	@Column(name = "username")
	public String getUsername()
	{
		return username;
	}
	
	@Column(name = "password")
	public String getPassword()
	{
		return password;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public void setRole(Roles role)
	{
		this.role = role;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
	
}
