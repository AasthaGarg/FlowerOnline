package com.ecommerce.flower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.flower.entity.Product;
import com.ecommerce.flower.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	
	@PostMapping("/addProductWithImage")
	public String addProductWithImage(@RequestBody Product product) {
		return ps.addProductwithImage(product);
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(@RequestBody Product product) {
		String res= ps.updateProduct(product);
        return res;
	}
	
	@PostMapping("/deleteProduct")
	public String deleteProduct(@RequestBody Product product) {
		return ps.deleteProduct(product);

	}
	
	@GetMapping("/getAllProductWithImage")
	public List<Product> getAllProductWithImage() {
		return ps.getAllProductWithImage();
		
	}
	
	@PostMapping("getByCategory")
	public List<Product> getByCategory(@RequestBody Product product) {
		return ps.getByCategory(product);
	}
	
	@PostMapping("/getProductByName")
	public List<Product> getProductByName(@RequestBody Product product) {
		return ps.getProductByName(product);

	}

	@PostMapping("/sortBySize")
	public List<Product> sortBySize(@RequestBody Product product) {
		return ps.sortBySize(product);

	}

	@PostMapping("/sortByPrice")
	public List<Product> sortByPrice(@RequestBody Product product) {
		return ps.sortByPrice(product);

	}
	
	

}
