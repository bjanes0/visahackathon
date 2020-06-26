package com.visa.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visa.springboot.exception.ResourceNotFoundException;
import com.visa.springboot.model.gift_campaigns;
import com.visa.springboot.repository.gift_campaigns_repository;


@RestController
@RequestMapping("/api/v1/")
public class gift_campaigns_controller {
	
	@Autowired
	private gift_campaigns_repository giftCampaignsRepository;
	// get gift givers
	
	@GetMapping("gift_campaigns")
	public List<gift_campaigns> getAllGiftCampaigns(){
		return this.giftCampaignsRepository.findAll();
	}
	
	// get gift givers by id
	  @GetMapping("/gift_campaigns/{giftCampaignId}")
	    public ResponseEntity<gift_campaigns> getGiftCampaignById(@PathVariable(value = "giftCampaignId") String giftCampaignId)
	        throws ResourceNotFoundException {
	        gift_campaigns giftCampaign = giftCampaignsRepository.findById(giftCampaignId)
	          .orElseThrow(() -> new ResourceNotFoundException("Campaign not found for this id :: " + giftCampaignId));
	        return ResponseEntity.ok().body(giftCampaign);
	    }	 
	
	// save gift giver
	    
	    @PostMapping("/gift_campaigns")
	    public gift_campaigns createGiftCampaign(@Valid @RequestBody gift_campaigns giftCampaigns) {
	        return giftCampaignsRepository.save(giftCampaigns);
	    }	    
	    
	// update gift giver
	    
	    @PutMapping("/gift_campaigns/{giftCampaignId}")
	    public ResponseEntity<gift_campaigns> updateCampaign(@PathVariable(value = "giftCampaignId") String giftCampaignId,
	         @Valid @RequestBody gift_campaigns giftCampaignDetails) throws ResourceNotFoundException {
	        gift_campaigns giftCampaign = giftCampaignsRepository.findById(giftCampaignId)
	        .orElseThrow(() -> new ResourceNotFoundException("Campaign not found for this id :: " + giftCampaignId));

	        giftCampaign.setGiftCampaignId(giftCampaignDetails.getGiftCampaignId());
	        giftCampaign.setEndDate(giftCampaignDetails.getEndDate());
	        giftCampaign.setStartDate(giftCampaignDetails.getStartDate());
	        giftCampaign.setGiftTotal(giftCampaignDetails.getGiftTotal());
	        giftCampaign.setRecipientEmail(giftCampaignDetails.getRecipientEmail());
	        giftCampaign.setTotalGifters(giftCampaignDetails.getTotalGifters());
	    
	        final gift_campaigns updatedGiftCampaign = giftCampaignsRepository.save(giftCampaign);
	        return ResponseEntity.ok(updatedGiftCampaign);
	    }	    
	    
	   
	    
	// delete gift giver
	    
	    @DeleteMapping("/gift_campaigns/{giftCampaignId}")
	    public Map<String, Boolean> deleteCampaign(@PathVariable(value = "giftCampaignId") String giftCampaignId)
	         throws ResourceNotFoundException {
	        gift_campaigns giftCampaign = giftCampaignsRepository.findById(giftCampaignId)
	       .orElseThrow(() -> new ResourceNotFoundException("Campaign not found for this id :: " + giftCampaignId));

	        giftCampaignsRepository.delete(giftCampaign);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    

}
