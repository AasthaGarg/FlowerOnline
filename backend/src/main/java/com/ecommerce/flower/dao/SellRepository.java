package com.ecommerce.flower.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.flower.entity.Sell;

public interface SellRepository extends JpaRepository<Sell, Integer> {
	
	@Query(value = "select * from sell where date_of_purchase=current_date",nativeQuery= true)
	List<Sell> getTodaysData();
	
	@Query(value = "select * from sell where date_trunc('week',date_of_purchase) = date_trunc('week',CURRENT_DATE)",nativeQuery= true)
	List<Sell> getWeeklyData();
	
	@Query(value = "select * from sell where date_trunc('month',date_of_purchase) = date_trunc('month',CURRENT_DATE)",nativeQuery= true)
	List<Sell> getMonthlyData();

}
