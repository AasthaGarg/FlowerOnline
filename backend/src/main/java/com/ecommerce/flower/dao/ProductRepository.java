package com.ecommerce.flower.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.flower.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query(value="select * from product where category=?1",nativeQuery=true)
	List<Product> findByCategory(String category);

	@Query(value="select * from product where name=?1",nativeQuery=true)
	List<Product> findByName(String name);
	
	@Query(value="select * from product order by size",nativeQuery=true)
	List<Product> sortBySizeAll();
	
	@Query(value="select * from product where category=?1 order by size",nativeQuery=true)
	List<Product> sortBySizeCategory(String category);
	
	@Query(value = " select * from product order by size DESC",nativeQuery= true)
	List<Product> sortBySizeAllDec();

	@Query(value = " select * from product where category=?1 order by size DESC",nativeQuery= true)
	List<Product> sortBySizeCategoryDec(String category);

	@Query(value = " select * from product order by price",nativeQuery= true)
	List<Product> sortByPriceAll();

	@Query(value = " select * from product order by price DESC",nativeQuery= true)
	List<Product> sortByPriceAllDec();

	@Query(value = " select * from product where category=?1 order by price ",nativeQuery= true)
	List<Product> sortByPriceCategory(String category);

	@Query(value = " select * from product where category=?1 order by price DESC ",nativeQuery= true)
	List<Product> sortByPriceCategoryDec(String category);
    
	@Query(value = " select * from product where category=?1 and name=?2 and size=?3",nativeQuery= true)
	Product findByNameAndCategoryAndSize(String category,String name,String size);
	
	
}
