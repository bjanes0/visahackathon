package com.visa.springboot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login_info")
public class login_info {
		
	private String userId;	
	private String email;	
	private String password;
	
	public login_info() {}
	
	public login_info(String userId, String email, String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
	}

	@Id
	@Column(name="userid")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "login_info [userId=" + userId + ", email=" + email + ", password=" + password + "]";
	}
	
	

	
	



	
	

}


