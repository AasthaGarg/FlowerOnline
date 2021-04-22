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

import com.ecommerce.flower.dao.ProductRepository;
import com.ecommerce.flower.entity.Product;
import com.ecommerce.flower.service.ProductService;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
class ProductTests {

	@Autowired
	ProductService ps;
	
	@MockBean
	private ProductRepository pr;
	
	@Test
	@DisplayName("Test getProductByName Success")
	void testProductByName() {
		
		// Setup our mock repository
		Product obj1 = new Product();
		obj1.setName("flower");
		Product res1 = new Product();
        Product res2 = new Product();
        
		org.mockito.Mockito.doReturn(Arrays.asList(res1, res2)).when(pr).findByName("flower");

        // Execute the service call
        List<Product> actualRes = ps.getProductByName(obj1);

        // Assert the response
        Assertions.assertEquals(2, actualRes.size(), "getProductByName should return 2 Product");
		
	}
	
	@Test
	@DisplayName("Test getProductByCategory Success")
	void testProductByCategory() {
		
		// Setup our mock repository
		Product obj1 = new Product();
		obj1.setCategory("Birthday");
		Product res1 = new Product();
        Product res2 = new Product();
        
		org.mockito.Mockito.doReturn(Arrays.asList(res1, res2)).when(pr).findByCategory("Birthday");

        // Execute the service call
        List<Product> actualRes = ps.getByCategory(obj1);

        // Assert the response
        Assertions.assertEquals(2, actualRes.size(), "getProductByCategory should return 2 Product");
		
	}
	
	@Test
	@DisplayName("Test addProductwithImage Success")
	void testaddProductwithImage() {
		
		// Setup our mock repository
		Product obj1 = new Product();
		obj1.setCategory("Birthday");
		obj1.setName("b1");
		obj1.setSize("Large");
		Product res1 = new Product();

        
		org.mockito.Mockito.doReturn(null).when(pr).findByNameAndCategoryAndSize(obj1.getCategory(), obj1.getName(),obj1.getSize());
		org.mockito.Mockito.doReturn(res1).when(pr).save(obj1);
        // Execute the service call
        String actualRes = ps.addProductwithImage(obj1);

        // Assert the response
        Assertions.assertEquals("Success", actualRes, "addProductwithImage should return Success");
		
	}

}