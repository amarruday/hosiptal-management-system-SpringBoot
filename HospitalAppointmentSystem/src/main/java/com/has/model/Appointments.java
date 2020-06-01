package com.has.model;

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

@Entity
@Table(name="appointments")
public class Appointments
{
	private int appId; 
	private Users users; 
	private String firstName; 
	private String lastName; 
	private String email; 
	private String contactNumber; 
	private String doctor; 
	private String diseaseDesc; 
	private String appointmentDate; 
	private String appointmentTime;
	private String status;
	private String created_by; 
	private Timestamp created_date; 
	private String updated_by; 
	private Timestamp updated_date;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "app_id")
	public int getAppId()
	{
		return appId;
	}

	@JoinColumn(name="user_id")
	@ManyToOne(targetEntity = Users.class)
	public Users getUsers()
	{
		return users;
	}

	@Column(name = "first_name")
	public String getFirstName()
	{
		return firstName;
	}

	@Column(name = "last_name")
	public String getLastName()
	{
		return lastName;
	}

	@Column(name = "email")
	public String getEmail()
	{
		return email;
	}

	@Column(name = "contact_number")
	public String getContactNumber()
	{
		return contactNumber;
	}

	@Column(name = "doctor")
	public String getDoctor()
	{
		return doctor;
	}

	@Column(name = "disease_desc")
	public String getDiseaseDesc()
	{
		return diseaseDesc;
	}

	@Column(name = "appointment_date")
	public String getAppointmentDate()
	{
		return appointmentDate;
	}

	@Column(name="appointment_time")
	public String getAppointmentTime()
	{
		return appointmentTime;
	}

	@Column(name="created_by")
	public String getCreated_by()
	{
		return created_by;
	}

	@Column(name="created_date")
	public Timestamp getCreated_date()
	{
		return created_date;
	}

	@Column(name="updated_by")
	public String getUpdated_by()
	{
		return updated_by;
	}
	
	@Column(name="status")
	public String getStatus() {
		return status;
	}

	@Column(name="updated_date")
	public Timestamp getUpdated_date()
	{
		return updated_date;
	}

	public void setAppId(int appId)
	{
		this.appId = appId;
	}

	public void setUsers(Users users)
	{
		this.users = users;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setContactNumber(String contactNumber)
	{
		this.contactNumber = contactNumber;
	}

	public void setDoctor(String doctor)
	{
		this.doctor = doctor;
	}

	public void setDiseaseDesc(String diseaseDesc)
	{
		this.diseaseDesc = diseaseDesc;
	}

	public void setAppointmentDate(String appointmentDate)
	{
		this.appointmentDate = appointmentDate;
	}

	public void setAppointmentTime(String appointmentTime)
	{
		this.appointmentTime = appointmentTime;
	}

	public void setCreated_by(String created_by)
	{
		this.created_by = created_by;
	}

	public void setCreated_date(Timestamp created_date)
	{
		this.created_date = created_date;
	}

	public void setUpdated_by(String updated_by)
	{
		this.updated_by = updated_by;
	}

	public void setUpdated_date(Timestamp updated_date)
	{
		this.updated_date = updated_date;
	}
		
	public void setStatus(String status)
	{
		this.status = status;
	}

	@Override
	public String toString()
	{
		return "Appointments [appId=" + appId + ", users=" + users + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", email=" + email + ", contactNumber=" + contactNumber + ", doctor=" + doctor + ", diseaseDesc=" + diseaseDesc
			+ ", appointmentDate=" + appointmentDate + ", appointmentTime=" + appointmentTime + ", status=" + status
			+ ", created_by=" + created_by + ", created_date=" + created_date + ", updated_by=" + updated_by
			+ ", updated_date=" + updated_date + "]";
	}
	
}
