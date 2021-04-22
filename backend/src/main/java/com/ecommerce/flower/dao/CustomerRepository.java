package com.ecommerce.flower.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.flower.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query(value="select * from customer where country=?1",nativeQuery=true)
	List<Customer> getByCountry(String country);
    
	@Query(value="select * from customer where city=?1",nativeQuery=true)
	List<Customer> getByCity(String city);
	
	@Query(value="select distinct city from customer",nativeQuery=true)
	List<String> listAllCity();
	
	@Query(value = "select distinct country from customer",nativeQuery= true)
	List<String> listAllCountry();

	@Query(value = "select * from customer where fname=?1",nativeQuery= true)
	Customer getByFname(String fname);
	
	@Query(value = "select * from customer where uid=?1",nativeQuery= true)
	Customer getByUid(int i);

	@Query(value = "select * from customer where fname=?1 and password=?2",nativeQuery= true)
	Customer getByUidAndPassword(String fname, String password);
}
