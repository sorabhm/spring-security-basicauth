package com.springsecurity.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springsecurity.model.Geolocation;

@Repository
public class GeolocationRepository {

	private List<Geolocation> geolocations = new ArrayList<Geolocation>();

	public void addGeoLocation(Geolocation geolocation) { 
        geolocations.add(geolocation); 
      } 

     public List<Geolocation> getGeoLocations() { 
        return Collections.unmodifiableList(geolocations); 
     }
	
	public List<Geolocation> findByUserId(String userId) {
		System.out.println("User id = " + userId);
		List<Geolocation> geosForUser = new ArrayList<>();
		for (Geolocation geolocation : geolocations) {
			if(userId.equalsIgnoreCase(geolocation.getUserId().toString())) {
				geosForUser.add(geolocation);
			}
		}
		return Collections.unmodifiableList(geosForUser);
	}
}
