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
import com.visa.springboot.model.gifts;
import com.visa.springboot.repository.gifts_repository;


@RestController
@RequestMapping("/api/v1/")
public class gifts_controller {
	
	@Autowired
	private gifts_repository giftsRepository;
	// get gift givers
	
	@GetMapping("gifts")
	public List<gifts> getAllGiftGivers(){
		return this.giftsRepository.findAll();
	}
	
	// get gift givers by id
	  @GetMapping("/gifts/{giftid}")
	    public ResponseEntity<gifts> getGiftGIverById(@PathVariable(value = "giftid") String giftid)
	        throws ResourceNotFoundException {
	        gifts gift = giftsRepository.findById(giftid)
	          .orElseThrow(() -> new ResourceNotFoundException("Gift not found for this id :: " + giftid));
	        return ResponseEntity.ok().body(gift);
	    }	 
	
	// save gift giver
	    
	    @PostMapping("/gifts")
	    public gifts createGiftGiver(@Valid @RequestBody gifts gift) {
	        return giftsRepository.save(gift);
	    }	    
	    
	// update gift giver
	    
	    @PutMapping("/gifts/{giftid}")
	    public ResponseEntity<gifts> updateGift(@PathVariable(value = "giftid") String giftid,
	         @Valid @RequestBody gifts giftDetails) throws ResourceNotFoundException {
	        gifts gift = giftsRepository.findById(giftid)
	        .orElseThrow(() -> new ResourceNotFoundException("Gift not found for this id :: " + giftid));

	        gift.setGiftCampaignId(giftDetails.getGiftCampaignId());
	        gift.setAmount(giftDetails.getAmount());
	        gift.setGiftDate(giftDetails.getGiftDate());
	        gift.setGiftId(giftDetails.getGiftId());
	        gift.setUserId(giftDetails.getUserId());
	        gift.setGiftMessage(giftDetails.getGiftMessage());
	    
	        final gifts updatedGift = giftsRepository.save(gift);
	        return ResponseEntity.ok(updatedGift);
	    }	    
	    
	   
	    
	// delete gift giver
	    
	    @DeleteMapping("/gifts/{giftid}")
	    public Map<String, Boolean> deleteGift(@PathVariable(value = "giftid") String giftid)
	         throws ResourceNotFoundException {
	        gifts gift = giftsRepository.findById(giftid)
	       .orElseThrow(() -> new ResourceNotFoundException("Gift not found for this id :: " + giftid));

	        giftsRepository.delete(gift);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}
