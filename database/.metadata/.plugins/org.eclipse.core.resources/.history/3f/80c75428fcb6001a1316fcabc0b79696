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
import com.visa.springboot.model.user_info;
import com.visa.springboot.repository.user_info_repository;


@RestController
@RequestMapping("/api/v1/")
public class user_info_controller {

	@Autowired
	private user_info_repository userInfoRepository;
	
	// get users
	@GetMapping("user_info")
	public List<user_info> getAllUsers(){
		return this.userInfoRepository.findAll();
	}
	
	// get a user by id
	  @GetMapping("/user_info/{userId}")
	    public ResponseEntity<user_info> getUserById(@PathVariable(value = "userId") String userId)
	        throws ResourceNotFoundException {
	        user_info userInfo = userInfoRepository.findById(userId)
	          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
	        return ResponseEntity.ok().body(userInfo);
	    }	 
	
	// save a user 
	    @PostMapping("/user_info")
	    public user_info createUser(@Valid @RequestBody user_info userInfo) {
	        return userInfoRepository.save(userInfo);
	    }	    
	    
	// update a user	    
	    @PutMapping("/user_info/{userId}")
	    public ResponseEntity<user_info> updateUser(@PathVariable(value = "userId") String userId,
	         @Valid @RequestBody user_info userDetails) throws ResourceNotFoundException {
	        user_info userInfo = userInfoRepository.findById(userId)
	        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	        userInfo.setUserId(userDetails.getUserId());
	        userInfo.setFirstName(userDetails.getFirstName());
	        userInfo.setLastName(userDetails.getLastName());
	        userInfo.setDob(userDetails.getDob());
	        userInfo.setTelephone(userDetails.getTelephone());
	        userInfo.setEmail(userDetails.getEmail());
	        userInfo.setPassword(userDetails.getPassword());
	    
	        final user_info updatedUserInfo = userInfoRepository.save(userInfo);
	        return ResponseEntity.ok(updatedUserInfo);
	    }	    
	    
	   
	    
	// delete a user 
	    @DeleteMapping("/user_id/{userId}")
	    public Map<String, Boolean> deleteUser(@PathVariable(value = "userId") String userId)
	         throws ResourceNotFoundException {
	        user_info userInfo = userInfoRepository.findById(userId)
	       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	        userInfoRepository.delete(userInfo);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    
}
	    
	    
	    