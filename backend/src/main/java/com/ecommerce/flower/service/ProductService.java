package com.ecommerce.flower.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.flower.dao.ProductRepository;
import com.ecommerce.flower.entity.Product;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductRepository rep;
	
	public String updateProduct(Product product) {
		product.setDate(new Date());
		rep.save(product);
		return "Success";
	}
	
	public String deleteProduct(Product product) {
		rep.deleteById(product.getPid());
		return "Success";
	}
	
	public List<Product> getByCategory(Product product){
		return rep.findByCategory(product.getCategory());
	}
	
	public List<Product> getProductByName(Product product) {
		// TODO Auto-generated method stub
		return rep.findByName(product.getName());
	}
	
	public List<Product> sortBySize(Product product){
		if(product.getCategory().equals("all")) {
			if(product.getSize().equals("Asc"))
				return rep.sortBySizeAll();
			else
				return rep.sortBySizeAllDec();
		}else {
			if(product.getSize().equals("Asc"))
				return rep.sortBySizeCategory(product.getCategory());
			else
				return rep.sortBySizeCategoryDec(product.getCategory());
		}
	}
	
	public List<Product> sortByPrice(Product product) {
		// TODO Auto-generated method stub
		if(product.getCategory().equals("all")) {
			if(product.getSize().equals("Asc")) {
				return rep.sortByPriceAll();
			}else {
				return rep.sortByPriceAllDec();
			}
			
		}else {
			if(product.getSize().equals("Asc")) {
				return rep.sortByPriceCategory(product.getCategory());
			}else {
				return rep.sortByPriceCategoryDec(product.getCategory());
			}
			
		}
	}
	
	public String addProductwithImage(Product product) {
		// TODO Auto-generated method stub
	    Product p= rep.findByNameAndCategoryAndSize(product.getCategory(),product.getName(),product.getSize());
	    String msg="";
		
		if(p==null) {
			
			product.setDate(new Date());
			rep.save(product);
			msg="Success";
		}else {
			
			msg="Product already exists";
		}
		return msg;
	
	}

	public List<Product> getAllProductWithImage() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}
	
	
}
