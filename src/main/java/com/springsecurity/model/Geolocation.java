package com.springsecurity.model;

import java.io.Serializable;
import java.util.UUID;

public class Geolocation implements Serializable {

	private static final long serialVersionUID = 1L;

	private double latitude;
	private double longitude;
	private UUID userId;
	private long timestamp;
	
	protected Geolocation() {
		
	}
	/**
	 * @param latitude
	 * @param longitude
	 * @param userId
	 * @param timestamp
	 */
	public Geolocation(double latitude, double longitude, UUID userId, long timestamp) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.userId = userId;
		this.timestamp = timestamp;
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public UUID getUserId() {
		return userId;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Geolocation [latitude=" + latitude + ", longitude=" + longitude + ", userId=" + userId + ", timestamp="
				+ timestamp + "]";
	}
	
	
	
}
