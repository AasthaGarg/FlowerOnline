package com.ecommerce.flower.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.flower.dao.CartRepository;
import com.ecommerce.flower.entity.Cart;

@Service
@Transactional
public class CartService {
	
	@Autowired
	CartRepository cartrepo;
	
	public Cart addToCart(Cart cart) {
		Cart obj= new Cart();
		Cart c1= cartrepo.findAllByUserAndProductId(cart.getCcid().getUid(), cart.getCpid().getPid());
		if(c1==null) {
			cart.setDate(new Date());
			obj=cartrepo.save(cart);
			return obj;
		} else {
			return null;
		}
	}

	public List<Cart> getCartById(Cart cart) {
		// TODO Auto-generated method stub
		return cartrepo.findAllByUid(cart.getCcid().getUid());
		
	}

	public Cart updateCart(Cart cart) {
		Cart obj= new Cart();
		obj=cartrepo.save(cart);
		return obj;
	}

	public String deleteCart(Cart cart) {
		// TODO Auto-generated method stub
		cartrepo.deleteById(cart.getCid());
		return "Success";
	}

}
