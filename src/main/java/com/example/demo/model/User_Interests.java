package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="user_interest")
public class User_Interests {
	@Id
	  @Column
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int user_interest_id;

	 

	  private int u_id;
	 
		

	  private int i_id;


	public User_Interests() {
		super();
	}


	public User_Interests(int u_id, int i_id) {
		super();
		this.u_id = u_id;
		this.i_id = i_id;
	}


	public int getUser_interest_id() {
		return user_interest_id;
	}


	public void setUser_interest_id(int user_interest_id) {
		this.user_interest_id = user_interest_id;
	}


	public int getU_id() {
		return u_id;
	}


	public void setU_id(int u_id) {
		this.u_id = u_id;
	}


	public int getI_id() {
		return i_id;
	}


	public void setI_id(int i_id) {
		this.i_id = i_id;
	}


	
}
