package com.ecommerce.flower.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.flower.entity.Feedback;
import com.ecommerce.flower.service.EmailService;

@RestController
@CrossOrigin
public class FeedbackController {
	
	@Autowired
	private EmailService sender;
		
	@PostMapping("/sendfeedback")
	public ResponseEntity<Feedback> sendfeedback(@RequestBody Feedback feedback) {
		try {
			sender.sendEmail(feedback);
			return new ResponseEntity<>(feedback, HttpStatus.OK);
		} catch(MessagingException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/getfeedback")
	public ResponseEntity<Feedback> getfeedback(@RequestBody Feedback feedback) {
		try {
			sender.getEmail(feedback);
			return new ResponseEntity<>(feedback, HttpStatus.OK);
		} catch(MessagingException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/sendOrderEmail")
	public ResponseEntity<Feedback> sendOrderDetails(@RequestBody Feedback feedback) {
		try {
			sender.sendOrderEmail(feedback);
			return new ResponseEntity<>(feedback, HttpStatus.OK);
		} catch(MessagingException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/contactUs")
	public ResponseEntity<Feedback> contactUs(@RequestBody Feedback feedback) {
		try {
			sender.contactUs(feedback);
			return new ResponseEntity<>(feedback, HttpStatus.OK);
		} catch(MessagingException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
