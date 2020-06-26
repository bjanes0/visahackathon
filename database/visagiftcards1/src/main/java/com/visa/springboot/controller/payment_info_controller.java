package com.visa.springboot.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import com.visa.springboot.model.payment_info;
import com.visa.springboot.repository.payment_info_repository;



@RestController
@RequestMapping("/api/v1/")
public class payment_info_controller {

	@Autowired
	private payment_info_repository paymentInfoRepository;
	
	// get payment info
	@GetMapping("payment_info")
	public List<payment_info> getAllPaymentInfos(){
		return this.paymentInfoRepository.findAll();
	}
	
	// get a payment info by id
	  @GetMapping("/payment_info/{userId}")
	    public ResponseEntity<payment_info> getPaymentInfoById(@PathVariable(value = "userId") String userId)
	        throws ResourceNotFoundException {
	        payment_info paymentInfo = paymentInfoRepository.findById(userId)
	          .orElseThrow(() -> new ResourceNotFoundException("Payment Info not found for this id :: " + userId));
	        return ResponseEntity.ok().body(paymentInfo);
	    }	 
	
	// save a user's payment info 
	    @PostMapping("/payment_info/{userId}")
	    public payment_info createPaymentInfo(@PathVariable(value = "userId") String userId, 
	    		@Valid @RequestBody payment_info paymentInfo) {
	    	
	    	paymentInfo.setUserId(userId);
	    	paymentInfo.setCardNumber(convert(paymentInfo.getCardNumber()));
	        return paymentInfoRepository.save(paymentInfo);
	    }	    
	    
//	// update a user's payment info	    
//	    @PutMapping("/payment_info/{userId}")
//	    public ResponseEntity<payment_info> updatePaymentInfo(@PathVariable(value = "userId") String userId,
//	         @Valid @RequestBody payment_info paymentInfoDetails) throws ResourceNotFoundException {
//	        payment_info paymentInfo = paymentInfoRepository.findById(userId)
//	        .orElseThrow(() -> new ResourceNotFoundException("Payment Info not found for this id :: " + userId));
//
//	        paymentInfo.setUserId(paymentInfoDetails.getUserId());
//	        paymentInfo.setCardNumber(paymentInfoDetails.getCardNumber());
//	        paymentInfo.setCvv(paymentInfoDetails.getCvv());
//	        paymentInfo.setLastFourDigits(paymentInfoDetails.getLastFourDigits());
//	        paymentInfo.setExpiryDate(paymentInfoDetails.getExpiryDate());
//	    
//	        final payment_info updatedPaymentInfo = paymentInfoRepository.save(paymentInfo);
//	        return ResponseEntity.ok(updatedPaymentInfo);
//	    }	    
	    
	   
	    
	// delete a user's payment info
	    @DeleteMapping("/payment_id/{userId}")
	    public Map<String, Boolean> deletePaymentInfo(@PathVariable(value = "userId") String userId)
	         throws ResourceNotFoundException {
	        payment_info paymentInfo = paymentInfoRepository.findById(userId)
	       .orElseThrow(() -> new ResourceNotFoundException("Payment Info not found for this id :: " + userId));

	        paymentInfoRepository.delete(paymentInfo);
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
	    
	    
	    