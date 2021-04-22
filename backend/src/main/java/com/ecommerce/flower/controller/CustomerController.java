package com.ecommerce.flower.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.flower.entity.Customer;
import com.ecommerce.flower.service.CustomerService;
import com.ecommerce.flower.service.EmailService;

@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	private EmailService sender;
	
	@PostMapping("/sendRegisterEmail")
	public ResponseEntity<Customer> sendRegisterEmail(@RequestBody Customer customer) {
		try {
			sender.sendRegisterEmail(customer);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch(MessagingException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login")
	public Customer login(@RequestBody Customer cust) {
		return cs.login(cust);
	}
	
	@PostMapping("/forgotPass")
	public String forgotPass(@RequestBody Customer cust) {
		return cs.forgotPassword(cust);
	}
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer() {
		return cs.getAllCustomer();

	}

	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer cust) {
		return cs.addCustomer(cust);

	}
	
	@PostMapping("getCustomerByCity")
	public List<Customer> getCustomerByCity(@RequestBody Customer cust) {
		return cs.getCustomerByCity(cust);
	}

	@PostMapping("getCustomerByCountry")
	public List<Customer> getCustomerByCountry(@RequestBody Customer cust) {
		return cs.getCustomerByCountry(cust);
	}

	@GetMapping("/listAllCity")
	public List<String> listAllCity() {
		return cs.listAllCity();

	}

	@GetMapping("/listAllCountry")
	public List<String> listAllCountry() {
		return cs.listAllCountry();

	}

}
