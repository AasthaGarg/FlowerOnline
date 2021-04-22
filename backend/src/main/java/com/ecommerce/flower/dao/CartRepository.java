package com.ecommerce.flower.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.flower.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	@Query(value = "select * from cart where ccid=?1",nativeQuery= true)
	List<Cart> findAllByUid(int ccid);
	
	@Query(value = "select * from cart where ccid=?1 and cpid=?2",nativeQuery= true)
	Cart findAllByUserAndProductId(int ccid,int cpid);
}
