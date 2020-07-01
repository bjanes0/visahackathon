package com.visa.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.springboot.dto.MailRequest;
import com.visa.springboot.dto.MailResponse;
import com.visa.springboot.service.EmailService;



@SpringBootApplication
@RestController
public class EmailServiceApplication {

	@Autowired
	private EmailService service;

	@PostMapping("/sendingEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("location", "California, US");
		return service.sendEmail(request, model);

	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

}
