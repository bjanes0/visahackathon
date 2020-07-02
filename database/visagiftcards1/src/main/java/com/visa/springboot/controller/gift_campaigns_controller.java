package com.visa.springboot.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.visa.springboot.model.gifts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:3000")
public class gift_campaigns_controller {
	
	@Autowired
	private gift_campaigns_repository giftCampaignsRepository;

	@Autowired
	private gifts_controller giftsController;
	
	// get gift campaigns
	@GetMapping("gift_campaigns")
	public List<gift_campaigns> getAllGiftCampaigns(){
		return this.giftCampaignsRepository.findAll();
	}
	
	// get gift campaign by id
	  @GetMapping("/gift_campaigns/{giftCampaignId}")
	    public ResponseEntity<gift_campaigns> getGiftCampaignById(@PathVariable(value = "giftCampaignId") String giftCampaignId)
	        throws ResourceNotFoundException {
	        gift_campaigns giftCampaign = giftCampaignsRepository.findById(giftCampaignId)
	          .orElseThrow(() -> new ResourceNotFoundException("Campaign not found for this id :: " + giftCampaignId));
	        return ResponseEntity.ok().body(giftCampaign);
	    }

	    @GetMapping("/gifts_in_campaign/{giftCampaignId}")
		public List<gifts> getGiftsInCampaign(@PathVariable(value = "giftCampaignId") String giftCampaignId) {
			List<gifts> all_gifts = giftsController.getAllGifts();
			List<gifts> campaignGifts = new ArrayList<>();
			for(gifts gift : all_gifts) {
				if(gift.getGiftCampaignId().equals(giftCampaignId)) {
					campaignGifts.add(gift);
				}
			}
			return campaignGifts;
		}
	
	// save gift campaign
	    @PostMapping("/gift_campaigns")
	    public gift_campaigns createGiftCampaign(@Valid @RequestBody gift_campaigns giftCampaigns) {
	        return giftCampaignsRepository.save(giftCampaigns);
	    }	    
	    
	// update gift campaign	    
	    @PutMapping("/gift_campaigns/{giftCampaignId}")
	    public ResponseEntity<gift_campaigns> updateCampaign(@PathVariable(value = "giftCampaignId") String giftCampaignId,
	         @Valid @RequestBody gift_campaigns giftCampaignDetails) throws ResourceNotFoundException {
	        gift_campaigns giftCampaign = giftCampaignsRepository.findById(giftCampaignId)
	        .orElseThrow(() -> new ResourceNotFoundException("Campaign not found for this id :: " + giftCampaignId));

	        //giftCampaign.setGiftCampaignId(giftCampaignDetails.getGiftCampaignId());
	        giftCampaign.setEndDate(giftCampaignDetails.getEndDate());
	        giftCampaign.setStartDate(giftCampaignDetails.getStartDate());
	        giftCampaign.setGiftTotal(giftCampaignDetails.getGiftTotal());
	        giftCampaign.setRecipientEmail(giftCampaignDetails.getRecipientEmail());
	        giftCampaign.setTotalGifters(giftCampaignDetails.getTotalGifters());
	        giftCampaign.setGiftCampaignName(giftCampaignDetails.getGiftCampaignName());
	        giftCampaign.setRecipientCardNumber(giftCampaignDetails.getRecipientCardNumber());
	    
	        final gift_campaigns updatedGiftCampaign = giftCampaignsRepository.save(giftCampaign);
	        return ResponseEntity.ok(updatedGiftCampaign);
	    }	    
	    
	   
	    
	// delete gift campaign	    
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
	    
	    public String convert(String s) {
	        try {
	            // Create MD5 Hash
	            MessageDigest digest = MessageDigest.getInstance("MD5");
	            digest.update(s.getBytes());
	            byte messageDigest[] = digest.digest();

	            // Create Hex String
	            StringBuilder hexString = new StringBuilder();
	            for (byte b : messageDigest) {
	                hexString.append(Integer.toHexString(0xFF & b));
	            }
	            return hexString.toString();
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
	    }
}
