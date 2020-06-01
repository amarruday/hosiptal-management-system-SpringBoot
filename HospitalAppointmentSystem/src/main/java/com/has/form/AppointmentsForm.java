package com.has.form;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class AppointmentsForm
{
	private int id; 
	private int userId; 
	private String firstName; 
	private String lastName; 
	private String email; 
	private String contactNumber; 
	private String doctor; 
	private String disease; 
	private String appointmentDate; 
	private String appointmentTime;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getContactNumber()
	{
		return contactNumber;
	}
	public void setContactNumber(String contactNumber)
	{
		this.contactNumber = contactNumber;
	}
	public String getDoctor()
	{
		return doctor;
	}
	public void setDoctor(String doctor)
	{
		this.doctor = doctor;
	}
	public String getDisease()
	{
		return disease;
	}
	public void setDisease(String disease)
	{
		this.disease = disease;
	}
	public String getAppointmentDate()
	{
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate)
	{
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentTime()
	{
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime)
	{
		this.appointmentTime = appointmentTime;
	}
	
}
