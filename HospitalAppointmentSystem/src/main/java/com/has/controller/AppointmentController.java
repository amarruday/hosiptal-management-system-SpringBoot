package com.has.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.has.dao.AppointmentDAO;
import com.has.form.AppointmentResponseOB;
import com.has.form.AppointmentsForm;
import com.has.model.Appointments;
import com.has.service.AppointmentService;
import com.has.utility.ApplicationCommonReturnObject;

@Controller
public class AppointmentController
{

	@Autowired
	private AppointmentService service;

	@Autowired
	private AppointmentDAO dao;

	@GetMapping(
	{ "/", "/home" })
	public String indexPage()
	{
		return "home";
	}

	@GetMapping("/login")
	public String loginPage()
	{
		return "login";
	}

	@GetMapping("/dashboard")
	private String dashboard()
	{
		return "dashboard";
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/loginUser")
	public String login(@RequestParam(value = "username", required = true) String username,
		@RequestParam(value = "password", required = true) String password, RedirectAttributes redAttr)
	{
		String forwardKey = "login";
		ApplicationCommonReturnObject commonReturnObject = new ApplicationCommonReturnObject();
		ArrayList<Appointments> appList = null;
		System.out.println("Username :" + username + " pass: " + password);
		if (username != null && !username.equals("") && password != null && !password.equals(""))
		{
			commonReturnObject = service.loginAndDashboard(username, password);
			if (commonReturnObject != null)
			{
				if (commonReturnObject.getOperationStatus().equals("SUCCESS"))
				{
					appList = (ArrayList<Appointments>) commonReturnObject.getReturnMapValue("appList");
					redAttr.addFlashAttribute("appList", appList);
					forwardKey = "redirect:/dashboard";
				}
				else
				{
					redAttr.addFlashAttribute("MSG", "Wrong Username or Password !");
					forwardKey = "redirect:/login";
				}
			}

		}
		return forwardKey;
	}

	@ResponseBody
	@GetMapping(value = "/addAppointment", produces = "application/json; charset=UTF-8")
	public AppointmentResponseOB addAppointment(@RequestParam(value = "firstname", required = true) String firstName,
		@RequestParam(value = "lastname", required = true) String lastName,
		@RequestParam(value = "email", required = true) String email,
		@RequestParam(value = "phone", required = true) String phone,
		@RequestParam(value = "doctor", required = true) String doctor,
		@RequestParam(value = "diseases", required = true) String diseases,
		@RequestParam(value = "date", required = true) String date,
		@RequestParam(value = "time", required = true) String time)
	{
		AppointmentsForm form = new AppointmentsForm();
		form.setFirstName(firstName.trim());
		form.setLastName(lastName.trim());
		form.setEmail(email.trim().toLowerCase());
		form.setContactNumber(phone.trim());
		form.setDoctor(doctor.trim());
		form.setDisease(diseases.trim());
		form.setAppointmentDate(date.trim());
		form.setAppointmentTime(time.trim());
		AppointmentResponseOB ajax = new AppointmentResponseOB();

		ajax = service.addAppointment(form);
		return ajax;
	}

	/*
	 * @ResponseBody
	 * 
	 * @GetMapping(value = "/testingDAO", produces =
	 * "application/json; charset=UTF-8") public ResponseEntity<List<Appointments>>
	 * testingDAO(
	 * 
	 * @RequestParam(value = "username", required = true) String username,
	 * 
	 * @RequestParam(value = "password", required = true) String password) throws
	 * Exception {
	 * 
	 * AppointmentResponseOB ajax = new AppointmentResponseOB(); return ajax;
	 * 
	 * 
	 * return ResponseEntity.ok().body(dao.checkAppointment(doctor, date, time,
	 * "FIXED"));
	 * 
	 * return ResponseEntity.ok().body(service.loginAndDashboard(username,
	 * password)); }
	 */

}
