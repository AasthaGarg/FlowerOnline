package com.ecommerce.flower.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.flower.dao.CustomerRepository;
import com.ecommerce.flower.entity.Customer;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	CustomerRepository cusrepo;
	
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return cusrepo.findAll();
	}

	public String addCustomer(Customer cust) {
		// TODO Auto-generated method stub
		Customer c1= cusrepo.getByFname(cust.getFname());
		String msg="";
		
		if(c1 == null) {
			cusrepo.save(cust);
			msg="Success";
		}else {
			msg="User name already exists";
		}
		return msg;
	}

	public List<Customer> getCustomerByCity(Customer cust) {
		// TODO Auto-generated method stub
		return cusrepo.getByCity(cust.getCity());
	}

	public List<Customer> getCustomerByCountry(Customer cust) {
		// TODO Auto-generated method stub
		return cusrepo.getByCountry(cust.getCountry());
	}

	public List<String> listAllCity() {
		// TODO Auto-generated method stub
		return cusrepo.listAllCity();
	}

	public List<String> listAllCountry() {
		// TODO Auto-generated method stub
		return cusrepo.listAllCountry();
	}

	public Customer login(Customer cust) {
		// TODO Auto-generated method stub
		Customer c1= cusrepo.getByUidAndPassword(cust.getFname(),cust.getPassword());
		return c1;
	}

	
	public String forgotPassword(Customer cust) {
		// TODO Auto-generated method stub
		String msg="";
		Customer c1= cusrepo.getByFname(cust.getFname());
		if(c1 != null) {
			c1.setPassword(cust.getPassword());
			cusrepo.save(c1);
			msg="Success";
		}else {
			msg="User name does not exists";
		}
		return msg;
		
	}
		
}
