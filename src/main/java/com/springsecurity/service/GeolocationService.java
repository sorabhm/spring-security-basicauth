package com.springsecurity.service;

import java.util.List;

import com.springsecurity.model.Geolocation;

public interface GeolocationService {

	public Geolocation create(Geolocation geolocation); 
    public List<Geolocation> findAll();
    public List<Geolocation> findByUserId(String userId);
}
