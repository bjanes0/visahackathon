package com.visa.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gift_givers")
public class gift_givers {
	
	@Id
	@Column(name = "userid")
	private long userId;
	
	@Column(name = "giftcampaignid")
	private long giftCampaignId;
	
	
	public gift_givers() {
		super();
	}



	public gift_givers(long giftCampaignId) {
		this.giftCampaignId = giftCampaignId;
	}
	
	
	
	public long getGiftCampaignId() {
		return giftCampaignId;
	}
	
	public void setGiftCampaignId(long giftCampaignId) {
		this.giftCampaignId = giftCampaignId;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	

}
