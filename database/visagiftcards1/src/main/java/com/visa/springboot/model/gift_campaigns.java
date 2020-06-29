package com.visa.springboot.model;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "gift_campaigns")
public class gift_campaigns {
	
	@Id
	@Column(name = "giftcampaignid")
	private String giftCampaignId = UUID.randomUUID().toString();
	

	@Column(name = "gifttotal")
	private int giftTotal;
	
	@Column(name = "startdate")
	private Date startDate;
	
	@Column(name = "enddate")
	private Date endDate;
	
	@Column(name = "totalgifters")
	private int totalGifters;
	
	@Column(name = "recipientemail")
	private String recipientEmail;
	
	@Column(name = "giftcampaignname")
	private String giftCampaignName;
	
	public gift_campaigns() {
		super();
	}
	
	
	public gift_campaigns(String giftCampaignName, int giftTotal, Date startDate, Date endDate, int totalGifters,
			String recipientEmail) {
		super();
		
		this.giftCampaignName = giftCampaignName;
		this.giftTotal = giftTotal;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalGifters = totalGifters;
		this.recipientEmail = recipientEmail;
	}
	
	public String getGiftCampaignName() {
		return giftCampaignName;
	}


	public void setGiftCampaignName(String giftCampaignName) {
		this.giftCampaignName = giftCampaignName;
	}


	public String getGiftCampaignId() {
		return giftCampaignId;
	}
	
	
	public void setGiftCampaignId(String giftCampaignId) {
		this.giftCampaignId = giftCampaignId;
	}


	public int getGiftTotal() {
		return giftTotal;
	}


	public void setGiftTotal(int giftTotal) {
		this.giftTotal = giftTotal;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public int getTotalGifters() {
		return totalGifters;
	}


	public void setTotalGifters(int totalGifters) {
		this.totalGifters = totalGifters;
	}


	public String getRecipientEmail() {
		return recipientEmail;
	}


	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	
	@Override
	public String toString() {
		return "gift_campaigns [giftCampaignId=" + giftCampaignId + ", giftTotal=" + giftTotal + ", startDate="
				+ startDate + ", endDate=" + endDate + ", totalGifters=" + totalGifters + ", recipientEmail="
				+ recipientEmail + ", giftCampaignName=" + giftCampaignName + "]";
	}




	
	
	
	

}
