package com.visa.springboot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_info")
public class payment_info {
		
	private String userId;	
	private String cardNumber;	
	private String lastFourDigits;
	private String expiryDate;
	private String cvv;
	
	public payment_info() {}
	
	public payment_info(String cardNumber, String lastFourDigits, String expiryDate, String cvv) {
		super();
		//this.userId = userId;
		this.cardNumber = cardNumber;
		this.lastFourDigits = lastFourDigits;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}
	
	@Id
	@Column(name="userid")
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name="cardnumber")
	public String getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Column(name="lastfourdigits")
	public String getLastFourDigits() {
		return lastFourDigits;
	}
	
	public void setLastFourDigits(String lastFourDigits) {
		this.lastFourDigits = lastFourDigits;
	}
	
	@Column(name="expirydate")
	public String getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@Column(name="cvv")
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "payment_info [userId=" + userId + ", cardNumber=" + cardNumber + ", lastFourDigits=" + lastFourDigits
				+ ", expiryDate=" + expiryDate + ", cvv=" + cvv + "]";
	}
	
	



	
	

}


