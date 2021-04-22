package com.ecommerce.flower.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.flower.dao.SellRepository;
import com.ecommerce.flower.entity.Sell;

@Service
@Transactional
public class SellService {
	
	@Autowired
	SellRepository selrepo;
	
	public String addSell(Sell sell) {
		
		Date d=new Date();
		sell.setDateOfPurchase(new Date(d.getTime()));
		Sell s = selrepo.save(sell);
		
		if(s!=null)
			return "Success";
		else
			return "Failure";
	}
	
	public List<Sell> sellReports(String report){
		if(report.equals("today"))
			return selrepo.getTodaysData();
		else if(report.equals("week"))
			return selrepo.getWeeklyData();
		else
			return selrepo.getMonthlyData();
	}

}
