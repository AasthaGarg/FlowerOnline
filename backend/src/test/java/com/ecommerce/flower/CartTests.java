package com.ecommerce.flower;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.flower.dao.CartRepository;
import com.ecommerce.flower.entity.Cart;
import com.ecommerce.flower.entity.Customer;
import com.ecommerce.flower.entity.Product;
import com.ecommerce.flower.service.CartService;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class CartTests {
	
	@Autowired
	CartService cs;
	
	@MockBean
	private CartRepository cr;
	
	@Test
	@DisplayName("Test getCartById Success")
	void testCartById() {
		
		// Setup our mock repository
		Cart obj1 = new Cart();
		Customer obj = new Customer();
		obj.setUid(1);
		obj1.setCcid(obj);
		Cart res1 = new Cart();
		
		org.mockito.Mockito.doReturn(Arrays.asList(res1)).when(cr).findAllByUid(obj1.getCcid().getUid());

        // Execute the service call
        List<Cart> actualRes = cs.getCartById(obj1);

        // Assert the response
        Assertions.assertEquals(1, actualRes.size(), "getCartById should return 1 Cart");
		
	}
	
	@Test
	@DisplayName("Test addToCart Success")
	void testaddToCart() {
		
		// Setup our mock repository
		Cart obj = new Cart();
		Customer obj1 = new Customer();
		obj1.setUid(1);
		Product obj2 = new Product();
		obj2.setPid(1);
		
		obj.setCpid(obj2);
		obj.setCcid(obj1);
		
		Cart res = new Cart();
		
		// Execute the service call
		org.mockito.Mockito.doReturn(null).when(cr).findAllByUserAndProductId(obj.getCcid().getUid(), obj.getCpid().getPid());
		org.mockito.Mockito.doReturn(res).when(cr).save(obj);
		
		Cart actualRes= cs.addToCart(obj);
		
		 // Assert the response
		 Assertions.assertEquals(res, actualRes, "addToCart should return 1 Cart");
	}

}
