package com.ecommerce.flower.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.flower.entity.Cart;
import com.ecommerce.flower.service.CartService;

@RestController
@CrossOrigin
public class CartController {
	
	@Autowired
	CartService ccs;
	
	@PostMapping("/addToCart")
	public Cart addToCart(@RequestBody Cart cart) {
		Cart c = ccs.addToCart(cart);
		return c;

	}

	@PostMapping("/addToCartMultiple")
	public List<Cart> addToCartMultiple(@RequestBody List<Cart> carts) {
		List<Cart> l1 = new ArrayList<>();
		Iterator<Cart> i = carts.iterator();
		Cart c1;
		Cart c2;
		while (i.hasNext()){
			c1=i.next();
			c2=ccs.addToCart(c1);
			l1.add(c2);
		}
		return l1;

	}

	@PostMapping("/getCartById")
	public List<Cart> getCartById(@RequestBody Cart cart) {
		List<Cart> carts = ccs.getCartById(cart);
		Iterator<Cart> i = carts.iterator();
		List<Cart> l1 = new ArrayList<>();
		Cart c1;
		while (i.hasNext()){
			c1=i.next();
			l1.add(c1);
		}
		return l1;

	}

	@PostMapping("/updateCart")
	public Cart updateCart(@RequestBody Cart cart) {
		Cart c2 = ccs.updateCart(cart);
		return c2;

	}

	@PostMapping("/deleteCart")
	public String deleteCart(@RequestBody Cart cart) {
		return ccs.deleteCart(cart);

	}

}
