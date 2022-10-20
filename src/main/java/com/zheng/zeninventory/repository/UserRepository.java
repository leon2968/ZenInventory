package com.zheng.zeninventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zheng.zeninventory.model.User;

/*
 * Repository for user
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	/*
	 * Method to find user by email
	 */
	User findByEmail(String email);
}