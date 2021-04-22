package com.ecommerce.flower.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.flower.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
	
	@Query("SELECT l FROM Location l WHERE l.name LIKE :n")
    List<Location> findByName(@Param("n") String name);

}
