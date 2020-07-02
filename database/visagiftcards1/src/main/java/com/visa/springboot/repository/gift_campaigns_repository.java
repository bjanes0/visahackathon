package com.visa.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.springboot.model.gift_campaigns;

@Repository
public interface gift_campaigns_repository extends JpaRepository<gift_campaigns, String> {

	
	
}
