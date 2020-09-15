package com.fdmgroup.soloproject_stephenripley.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.fdmgroup.soloproject_stephenripley.model.User;

public interface UserDao extends JpaRepository<User, Long>{
	
	User findById(@Param("userid") long userid);

}
