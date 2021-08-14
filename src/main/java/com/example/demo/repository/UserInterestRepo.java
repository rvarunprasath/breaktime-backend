package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
import com.example.demo.model.User_Interests;

@Repository
public interface UserInterestRepo extends CrudRepository<User_Interests, Integer> {

	@Query("select u.i_id from User_Interests u where u.u_id=?1")
	List<Integer> findByUserId(int id);
	
	@Query("select u from User_Interests u where u.u_id=?1 and u.i_id=?2")
	User_Interests findByUid(int userid,int interestid);
	
	@Query("select u.i_id from User_Interests u where u.u_id=?1 and u.i_id=?2")
	List<Integer> findUserInterestExists(int id, int interest_id);
}