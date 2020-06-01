package com.has.model;

public class Sample
{
	private String name;
	private String email;
	private String mobileNo;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getMobileNo()
	{
		return mobileNo;
	}
	public void setMobileNo(String mobileNo)
	{
		this.mobileNo = mobileNo;
	}
	
	@Override
	public String toString()
	{
		return "Sample [name=" + name + ", email=" + email + ", mobileNo=" + mobileNo + "]";
	}
}
