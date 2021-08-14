package com.example.demo.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Payload {

	String email;
	ArrayList<Integer> interest_ids;
	
	public Payload() {
		super();
	}
	
	public Payload(String email, ArrayList<Integer> interest_ids) {
		super();
		this.email = email;
		this.interest_ids = interest_ids;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Integer> getInterest_ids() {
		return interest_ids;
	}
	public void setInterest_ids(ArrayList<Integer> interest_ids) {
		this.interest_ids = interest_ids;
	}
	
}
