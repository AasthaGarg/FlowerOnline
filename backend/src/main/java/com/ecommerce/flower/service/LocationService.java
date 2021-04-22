package com.ecommerce.flower.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.flower.dao.LocationRepository;
import com.ecommerce.flower.entity.Location;

@Service
@Transactional
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	

	public Location editLocation(Location location) {
		Location existLocation = locationRepository.findById(location.getId()).orElse(null);
		   existLocation.setName(location.getName());
		   existLocation.setAddress(location.getAddress());
		   existLocation.setPhone(location.getPhone());
		   return locationRepository.save(existLocation);
	}

	
	public Location findLocationById(long id) {
		return locationRepository.findById(id).orElse(null);
	}


	public String deleteLocation(Location loc) {
		locationRepository.deleteById(loc.getId());
		return "Success";
	}


	public List<Location> findAllLocation() {
		return locationRepository.findAll();
	}


	public Location getLocation(long id) {
		return locationRepository.findById(id).orElse(null);
	}


	public Location addLocation(Location location) {
		return locationRepository.save(location);
	}


}
