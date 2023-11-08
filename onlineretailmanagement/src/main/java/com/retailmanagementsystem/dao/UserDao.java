package com.retailmanagementsystem.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.retailmanagementsystem.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {

	User findByUserEmail(String userEmail);
	

	
	
	
}
