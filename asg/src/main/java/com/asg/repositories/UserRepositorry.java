package com.asg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asg.entity.User;

@Repository
public interface UserRepositorry extends JpaRepository<User, Integer> {
	@Query("SELECT entity FROM User entity WHERE email= :email ")
	public User findByEmail(@Param("email") String email);
}
