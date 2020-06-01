package com.has.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.has.model.Appointments;

public interface AppointmentDAO extends JpaRepository<Appointments, Integer>
{

	@Query(value = "SELECT COUNT(*) FROM appointments WHERE doctor =:doctor AND appointment_date =:appDate AND appointment_time =:appTime AND STATUS =:status", nativeQuery = true)
	public int checkAppointment(@Param("doctor") String doctor, @Param("appDate") String date,
		@Param("appTime") String time, @Param("status") String status) throws Exception;
	
	@Query(value="SELECT * FROM appointment_db.appointments a WHERE user_id =:userId", nativeQuery = true)
	public ArrayList<Appointments> getAppointmentsByUserId(@Param("userId") int userId) throws Exception;

}
