package com.visa.springboot.model;


import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class user_info {
		
	private String userId;	
	private String firstName;	
	private String lastName;
	private Date dob;
	private char[] telephone = new char[10];
	
	public user_info() {
	}

	public user_info(String userId, String firstName, String lastName, Date dob, char[] telephone) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.telephone = telephone;
	}

	
	@Id
	@Column(name = "userid")
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "firstname")
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastname")
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "dob")
	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "telephone")
	public char[] getTelephone() {
		return telephone;
	}


	public void setTelephone(char[] telephone) {
		this.telephone = telephone;
	}
	
	@Override
	public String toString() {
		return "user_info [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", telephone=" + Arrays.toString(telephone) + "]";
	}




	
	

}

