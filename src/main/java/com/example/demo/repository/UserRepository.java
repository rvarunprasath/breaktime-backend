package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query("select u from User u where u.email=?1")
	User findByEmail(String email);
	
	@Query("select u.id from User u where u.email=?1")	
	int findIdByEmail(String email);
}