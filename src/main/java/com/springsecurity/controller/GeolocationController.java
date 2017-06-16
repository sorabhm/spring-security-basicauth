package com.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.springsecurity.model.Geolocation;
import com.springsecurity.service.GeolocationService;

@RestController
public class GeolocationController {

	@Autowired
	public GeolocationService service;
	
	@RequestMapping(method=RequestMethod.POST, path="/geolocation", produces="application/json", 
			consumes="application/json")
	public ResponseEntity<Void> create(@RequestBody Geolocation geoLocation, UriComponentsBuilder builder) {
		System.out.println("Creating GeoLocation for user = " + geoLocation.getUserId());
		service.create(geoLocation);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/geolocation/{id}").buildAndExpand(geoLocation.getUserId()).toUri());

		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/geolocation", produces="application/json")
	public ResponseEntity<List<Geolocation>> findAll() {
		List<Geolocation> listOfGeos = service.findAll();
		if(null == listOfGeos || listOfGeos.isEmpty()) {
			System.err.println("No Geo locations found, returning empty response");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listOfGeos, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/geolocation/{userId}", produces="application/json")
	public ResponseEntity<List<Geolocation>> findAll(@PathVariable("userId") String userId) {
		List<Geolocation> listOfGeos = service.findByUserId(userId);
		if(null == listOfGeos || listOfGeos.isEmpty()) {
			System.err.println("No Geo locations found, returning empty response");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listOfGeos, HttpStatus.OK);
	}
}
