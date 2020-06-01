package com.has.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.has.dao.AppointmentDAO;
import com.has.dao.RolesDAO;
import com.has.dao.UsersDAO;
import com.has.form.AppointmentResponseOB;
import com.has.form.AppointmentsForm;
import com.has.model.Appointments;
import com.has.model.Roles;
import com.has.model.Users;
import com.has.utility.ApplicationCommonReturnObject;
import com.has.utility.DateUtility;

@Service
public class AppointmentService
{
	@Autowired
	private AppointmentDAO dao;

	@Autowired
	private RolesDAO roleDAO;

	@Autowired
	private UsersDAO userDAO;

	public AppointmentResponseOB addAppointment(AppointmentsForm appointmentForm)
	{
		AppointmentResponseOB response = new AppointmentResponseOB();
		Roles role = roleDAO.getUserRole();
		Users user = null;
		Appointments app = null;
		int count = 0;
		try
		{
			
			user = userDAO.getUserByUsername(appointmentForm.getContactNumber());
			count = dao.checkAppointment(appointmentForm.getDoctor(), appointmentForm.getAppointmentDate(),
				appointmentForm.getAppointmentTime(), "FIXED");
			if (user != null)
			{
				// get all appointment against that user

				
				if (count > 0)
				{
					response.setStatus("FAILURE");
					response.setMessage("This Date and Time already alloted to another Patient! Please choose another time slot.");
				}
				else
				{
					app = new Appointments();
					app.setUsers(user);
					app.setFirstName(appointmentForm.getFirstName());
					app.setLastName(appointmentForm.getLastName());
					app.setEmail(appointmentForm.getEmail());
					app.setContactNumber(appointmentForm.getContactNumber());
					app.setDoctor(appointmentForm.getDoctor());
					app.setDiseaseDesc(appointmentForm.getDisease());
					app.setAppointmentDate(appointmentForm.getAppointmentDate());
					app.setAppointmentTime(appointmentForm.getAppointmentTime());
					app.setStatus("FIXED");
					app.setCreated_by(appointmentForm.getFirstName());
					app.setCreated_date(DateUtility.getCurrentTimeStamp());
					app = dao.save(app);

					if (app.getAppId() > 0)
					{
						response.setStatus("SUCCESS");
						response
							.setMessage("Your Appointment has been booked. Check status using your mobile number as credentials");
					}
				}
			}
			else
			{
				/*
				 * count = dao.checkAppointment(appointmentForm.getDoctor(),
				 * appointmentForm.getAppointmentDate(), appointmentForm.getAppointmentTime(),
				 * "FIXED");
				 */
				if (count > 0)
				{
					response.setStatus("FAILURE");
					response.setMessage("This Date and Time already alloted to another Patient! Please choose another time slot.");
				}
				else
				{
					user = new Users();
					user.setRole(role);
					user.setUsername(appointmentForm.getContactNumber());
					user.setPassword(appointmentForm.getContactNumber());
					user = userDAO.save(user);
					if (user.getUserId() > 0)
					{
						app = new Appointments();
						app.setUsers(user);
						app.setFirstName(appointmentForm.getFirstName());
						app.setLastName(appointmentForm.getLastName());
						app.setEmail(appointmentForm.getEmail());
						app.setContactNumber(appointmentForm.getContactNumber());
						app.setDoctor(appointmentForm.getDoctor());
						app.setDiseaseDesc(appointmentForm.getDisease());
						app.setAppointmentDate(appointmentForm.getAppointmentDate());
						app.setAppointmentTime(appointmentForm.getAppointmentTime());
						app.setStatus("FIXED");
						app.setCreated_by(appointmentForm.getFirstName());
						app = dao.save(app);
						if (app.getAppId() > 0)
						{
							response.setStatus("SUCCESS");
							response
								.setMessage("Your Appointment has been booked. Check status using your mobile number as credentials");
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return response;
	}

	public ApplicationCommonReturnObject loginAndDashboard(String username, String password)
	{
		ApplicationCommonReturnObject commonReturnObject = new ApplicationCommonReturnObject();
		ArrayList<Appointments> appList = null;
		Users user = null;
		try
		{
			user = userDAO.getUserByUsername(username);
			if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password))
			{
				appList = dao.getAppointmentsByUserId(user.getUserId());
				commonReturnObject.setOperationStatus("SUCCESS");
				commonReturnObject.setReturnMapValue("appList", appList);
			}
			else
			{
				commonReturnObject.setOperationStatus("FAILURE");
				commonReturnObject.setMessage("Wrong Username or Password!");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return commonReturnObject;
	}
}
