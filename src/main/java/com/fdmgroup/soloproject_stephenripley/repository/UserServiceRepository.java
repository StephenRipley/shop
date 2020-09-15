package com.fdmgroup.soloproject_stephenripley.repository;

public interface UserServiceRepository<User> {
	
	void save(User user);
	
	User findById(long userid);

}
