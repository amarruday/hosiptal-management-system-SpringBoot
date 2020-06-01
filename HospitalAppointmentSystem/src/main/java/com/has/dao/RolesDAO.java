package com.has.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.has.model.Roles;

public interface RolesDAO extends JpaRepository<Roles, Integer>
{
	@Query(value = "SELECT * FROM roles WHERE role_name = 'USER'", nativeQuery = true)
	public Roles getUserRole(	);
}
