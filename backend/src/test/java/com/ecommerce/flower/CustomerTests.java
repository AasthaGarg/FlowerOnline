package com.ecommerce.flower;


import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.flower.dao.CustomerRepository;
import com.ecommerce.flower.entity.Customer;
import com.ecommerce.flower.service.CustomerService;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class CustomerTests {
	
	@Autowired
	CustomerService cs;
	
	@MockBean
	private CustomerRepository cr;
	
	@Test
	@DisplayName("Test addCustomer Success")
	void testaddCustomer() {
		
		// Setup our mock repository
		Customer obj1 = new Customer();
		obj1.setFname("Aastha");
		Customer res1= new Customer();
        
		org.mockito.Mockito.doReturn(null).when(cr).getByFname("Aastha");
		org.mockito.Mockito.doReturn(res1).when(cr).save(obj1);

        // Execute the service call
        String actualRes = cs.addCustomer(obj1);

        // Assert the response
        Assertions.assertEquals("Success", actualRes, "addCustomer should return Success");
		
	}
	
	@Test
	@DisplayName("Test getCustomerByCity Success")
	void testCustomerByCity() {
		
		// Setup our mock repository
		Customer obj1 = new Customer();
		obj1.setCity("Pune");
		Customer res1 = new Customer();
		Customer res2 = new Customer();
		
		org.mockito.Mockito.doReturn(Arrays.asList(res1, res2)).when(cr).getByCity("Pune");

        // Execute the service call
        List<Customer> actualRes = cs.getCustomerByCity(obj1);

        // Assert the response
        Assertions.assertEquals(2, actualRes.size(), "getCustomerByCity should return 2 Customers");
		
	}
	
	@Test
	@DisplayName("Test getCustomerByCountry Success")
	void testCustomerByCountry() {
		
		// Setup our mock repository
		Customer obj1 = new Customer();
		obj1.setCountry("India");
		Customer res1 = new Customer();
		Customer res2 = new Customer();
		
		org.mockito.Mockito.doReturn(Arrays.asList(res1, res2)).when(cr).getByCountry("India");

        // Execute the service call
        List<Customer> actualRes = cs.getCustomerByCountry(obj1);

        // Assert the response
        Assertions.assertEquals(2, actualRes.size(), "getCustomerByCountry should return 2 Customers");
		
	}
	
	
	@Test
	@DisplayName("Test forgotPassword Success")
	void testforgotPassword() {
		
		// Setup our mock repository
		Customer obj1 = new Customer();
		obj1.setFname("Mahi");
		Customer res1 = new Customer();

		
		org.mockito.Mockito.doReturn(obj1).when(cr).getByFname("Mahi");
		obj1.setPassword("123");
		org.mockito.Mockito.doReturn(res1).when(cr).save(obj1);
		
        // Execute the service call
        String actualRes = cs.forgotPassword(obj1);

        // Assert the response
        Assertions.assertEquals("Success", actualRes, "forgotPassword should return Success");
		
	}
	
}
