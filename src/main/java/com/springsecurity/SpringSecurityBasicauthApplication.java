package com.springsecurity;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springsecurity.model.Geolocation;
import com.springsecurity.service.GeolocationService;

@SpringBootApplication
public class SpringSecurityBasicauthApplication implements CommandLineRunner {
	
	@Autowired
	private GeolocationService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityBasicauthApplication.class, args);
	}
	
	public void run(String...strings) throws Exception {
		
			//Loading data before start up
			System.out.println("Geolocation data setup started");
			Geolocation geo = new Geolocation(29.568012, 57.962444, UUID.randomUUID(), System.currentTimeMillis());
			service.create(geo);
			geo = new Geolocation(39.568012, 67.962444, UUID.randomUUID(), System.currentTimeMillis());
			service.create(geo);
			geo = new Geolocation(49.568012, 77.962444, UUID.randomUUID(), System.currentTimeMillis());
			service.create(geo);
			geo = new Geolocation(59.568012, 87.962444, UUID.randomUUID(), System.currentTimeMillis());
			service.create(geo);
			System.out.println("Geolocation data setup successfully completed");
	}
}
