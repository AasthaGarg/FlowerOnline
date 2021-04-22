package com.ecommerce.flower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.flower.entity.Location;
import com.ecommerce.flower.service.LocationService;

@RestController
@CrossOrigin
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	

	
	@PostMapping("/editLocation")
	public Location editLocation(@RequestBody Location location) {
	    Location res= locationService.editLocation(location);
        return res;
	}

	@PostMapping("/deleteLocation")
	public String deleteLocation(@RequestBody Location location) {
		String res=locationService.deleteLocation(location);
        return res;
	}

	 @GetMapping("/findAllLocations")
	 List<Location> findAllLocation() {
	   return locationService.findAllLocation();
	 }

	 
	 @PostMapping("/addLocation")
	 Location addLocation(@RequestBody Location location) {
	   return locationService.addLocation(location);
	 }

}
