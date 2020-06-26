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
import com.visa.springboot.model.login_info;
import com.visa.springboot.repository.login_info_repository;



@RestController
@RequestMapping("/api/v1/")
public class login_info_controller {

	@Autowired
	private login_info_repository loginInfoRepository;
	
	// get users' login info
	@GetMapping("login_info")
	public List<login_info> getAllLoginInfos(){
		return this.loginInfoRepository.findAll();
	}
	
	// get a user's login info by id
	  @GetMapping("/login_info/{userId}")
	    public ResponseEntity<login_info> getLoginInfoById(@PathVariable(value = "userId") String userId)
	        throws ResourceNotFoundException {
	        login_info loginInfo = loginInfoRepository.findById(userId)
	          .orElseThrow(() -> new ResourceNotFoundException("Login Info not found for this id :: " + userId));
	        return ResponseEntity.ok().body(loginInfo);
	    }	 
	
	// save a user's login info 
	    @PostMapping("/login_info")
	    public login_info createLoginInfo(@Valid @RequestBody login_info loginInfo) {
	        return loginInfoRepository.save(loginInfo);
	    }	    
	    
	// update a user's login info	    
	    @PutMapping("/login_info/{userId}")
	    public ResponseEntity<login_info> updateLoginInfo(@PathVariable(value = "userId") String userId,
	         @Valid @RequestBody login_info loginInfoDetails) throws ResourceNotFoundException {
	        login_info loginInfo = loginInfoRepository.findById(userId)
	        .orElseThrow(() -> new ResourceNotFoundException("Login Info not found for this id :: " + userId));

	        loginInfo.setUserId(loginInfoDetails.getUserId());
	        loginInfo.setEmail(loginInfoDetails.getEmail());
	        loginInfo.setPassword(loginInfo.getPassword());
	        final login_info updatedLoginInfo = loginInfoRepository.save(loginInfo);
	        return ResponseEntity.ok(updatedLoginInfo);
	    }	    
	    
	   
	    
	// delete a user's login info
	    @DeleteMapping("/login_id/{userId}")
	    public Map<String, Boolean> deleteLoginInfo(@PathVariable(value = "userId") String userId)
	         throws ResourceNotFoundException {
	        login_info loginInfo = loginInfoRepository.findById(userId)
	       .orElseThrow(() -> new ResourceNotFoundException("Login Info not found for this id :: " + userId));

	        loginInfoRepository.delete(loginInfo);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    
}
	    
	    
	    