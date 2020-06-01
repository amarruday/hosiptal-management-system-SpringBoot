package com.has.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.has.model.Users;

public interface UsersDAO extends JpaRepository<Users, Integer>
{
	@Query(value="SELECT * FROM users WHERE username =:username", nativeQuery = true)
	public Users getUserByUsername(@Param("username") String username) throws Exception;
}
