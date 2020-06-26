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
import com.visa.springboot.model.gift_givers;
import com.visa.springboot.repository.gift_givers_repository;


@RestController
@RequestMapping("/api/v1/")
public class gift_giver_controller {

	@Autowired
	private gift_givers_repository giftGiverRepository;
	// get gift givers
	
	@GetMapping("gift_givers")
	public List<gift_givers> getAllGiftGivers(){
		return this.giftGiverRepository.findAll();
	}
	
	// get gift givers by id
	  @GetMapping("/gift_givers/{userId}")
	    public ResponseEntity<gift_givers> getGiftGIverById(@PathVariable(value = "userId") Long userId)
	        throws ResourceNotFoundException {
	        gift_givers giftGiver = giftGiverRepository.findById(userId)
	          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
	        return ResponseEntity.ok().body(giftGiver);
	    }	 
	
	// save gift giver
	    
	    @PostMapping("/gift_givers")
	    public gift_givers createGiftGiver(@Valid @RequestBody gift_givers giftGiver) {
	        return giftGiverRepository.save(giftGiver);
	    }	    
	    
	// update gift giver
	    
	    @PutMapping("/gift_givers/{userId}")
	    public ResponseEntity<gift_givers> updateGiftGiver(@PathVariable(value = "userId") Long userId,
	         @Valid @RequestBody gift_givers giftGiverDetails) throws ResourceNotFoundException {
	        gift_givers giftGiver = giftGiverRepository.findById(userId)
	        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	        giftGiver.setGiftCampaignId(giftGiverDetails.getGiftCampaignId());
	    
	        final gift_givers updatedGiftGIver = giftGiverRepository.save(giftGiver);
	        return ResponseEntity.ok(updatedGiftGIver);
	    }	    
	    
	   
	    
	// delete gift giver
	    
	    @DeleteMapping("/gift_givers/{userId}")
	    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "userId") Long userId)
	         throws ResourceNotFoundException {
	        gift_givers giftGiver = giftGiverRepository.findById(userId)
	       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	        giftGiverRepository.delete(giftGiver);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    
	    
	    
	    
	    
	
}
