package com.ecommerce.flower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.flower.entity.Sell;
import com.ecommerce.flower.service.SellService;

@RestController
@CrossOrigin
public class SellController {
	
	@Autowired
	SellService ss;
	
	@PostMapping("/sellReports")
	public List<Sell> sellReports(@RequestBody String body) {
		return ss.sellReports(body);

	}

	@PostMapping("/addSell")
	public String addSell(@RequestBody Sell sel) {
		return ss.addSell(sel);
	}

}
