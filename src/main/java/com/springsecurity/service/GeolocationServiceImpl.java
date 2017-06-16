package com.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.model.Geolocation;
import com.springsecurity.repository.GeolocationRepository;

@Service
public class GeolocationServiceImpl implements GeolocationService {

	@Autowired
	public GeolocationRepository repo;
	
		
	@Override
	public Geolocation create(Geolocation geolocation) {
		repo.addGeoLocation(geolocation);
		return geolocation;
	}

	@Override
	public List<Geolocation> findAll() {
		return repo.getGeoLocations();
	}
	
	@Override
	public List<Geolocation> findByUserId(String userId) {
		return repo.findByUserId(userId);
	}

}
