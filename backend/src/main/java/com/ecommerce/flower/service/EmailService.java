package com.ecommerce.flower.service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ecommerce.flower.entity.Customer;
import com.ecommerce.flower.entity.Feedback;

@Service
@Transactional
public class EmailService {
	

	
	Feedback feedback = new Feedback();
	private JavaMailSender javaMailSender;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(Feedback email) throws MessagingException {
		
	        MimeMessage msg = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	        helper.setTo(email.getEmail());
	        helper.setFrom("flowerstoremanagement@gmail.com");
	        StringBuilder sb = new StringBuilder();
	        
	        sb.append("<h2>Hi " + email.getName() + ",</h2>");
	        sb.append("<div><p>Thank you for submitting the feedback. <b>" + "</b></p></div>");
	        sb.append("<div><p><br>Your response has saved successfully</p></div>");
	        sb.append("<div><b>Thanks & Regards,<br>" + "The Flowers Online Team" + "</div></p>");
	        helper.setSubject("Feedback Response Submitted SuccsessFully");
	        helper.setText(sb.toString(), true);
	        
	        javaMailSender.send(msg);
	    }
	
	
	  public void getEmail(Feedback feedback) throws MessagingException {
		  
		  	MimeMessage msg = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	        helper.setFrom(feedback.getEmail());
	        helper.setTo("flowerstoremanagement@gmail.com");
	        helper.setSubject(feedback.getSubject());
	        
	        StringBuilder sb = new StringBuilder();
	      
	        sb.append("<h2>Hi " + "Admin" + ",</h2>");
	        sb.append("<br>Feedback Details:");
	        sb.append("<br>Name: " + feedback.getName());
	        sb.append("<br>Email: " + feedback.getEmail());
	        sb.append("<br>Rating: " + feedback.getRatings());
	        sb.append("<br>Description: " +feedback.getDes() + "<br>");
	        sb.append("<br><div><b>Thanks & Regards,<br>" + feedback.getName() + "</div>"); 
	        helper.setText(sb.toString(), true);
	        
	        javaMailSender.send(msg);
		}

	  public void sendOrderEmail(Feedback feedback) throws MessagingException {
		  
		  MimeMessage msg = javaMailSender.createMimeMessage();
		  MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		  helper.setTo(feedback.getEmail());
		  helper.setSubject("Order Confirmation Email");
		  
		  StringBuilder sb = new StringBuilder();
		  
		  sb.append("<h2>Hi " + feedback.getName() + ",</h2>");
		  sb.append("<br>Your order has been placed successfully!");
		  sb.append("<br>Thank You for shopping with us :-)");
		  sb.append("<br><div><b>Thanks & Regards,<br>" + "The Flowers Online Team" + "</div>");
		  
		  helper.setText(sb.toString(), true);
	        
	      javaMailSender.send(msg);
	  }
	  
	  public void contactUs(Feedback feedback) throws MessagingException {
		  
		  MimeMessage msg = javaMailSender.createMimeMessage();
		  MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		  helper.setTo("flowerstoremanagement@gmail.com");
		  helper.setSubject(feedback.getName() + " is trying to contact you!");
		  
		  StringBuilder sb = new StringBuilder();
		  
		  sb.append("<h2>Hi " + "Admin" + ",</h2>");
		  sb.append("<br>Email: " + feedback.getEmail());
		  sb.append("<br>Query: " + feedback.getDes());
		  sb.append("<br><br>Looking forward to your response<br>");
		  sb.append("<br><div><b>Thanks & Regards,<br>" + feedback.getName() + "</div>");
		  
		  helper.setText(sb.toString(), true);
	        
	      javaMailSender.send(msg);
	  }
	  
	  public void sendRegisterEmail(Customer customer) throws MessagingException {
		  
	        MimeMessage msg = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	        helper.setTo(customer.getEmail());
	        helper.setFrom("flowerstoremanagement@gmail.com");
	        StringBuilder sb = new StringBuilder();
	        
	        sb.append("<h2>Hi " + customer.getFname() + " " + customer.getLname() + ",</h2>");
	        sb.append("<div><p><b>You have been registered successfully! " + "</b></p></div>");
	        sb.append("<div><p><br>Welcome to the world of Flowers :-)</p></div>");
	        sb.append("<div><b>Thanks & Regards,<br>" + "The Flowers Online Team" + "</div></p>");
	        helper.setSubject("Registration Successfull! ");
	        helper.setText(sb.toString(), true);
	        
	        javaMailSender.send(msg);
	    }

}
