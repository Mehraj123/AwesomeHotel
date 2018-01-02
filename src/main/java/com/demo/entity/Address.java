package com.demo.entity;

import org.hibernate.validator.constraints.NotBlank;

public class Address {
	@NotBlank(message = "Country cannot be blank")
	private String country;
	@NotBlank(message = "City cannot be blank")
	private String city;

	public Address() {
	}

	public Address(String country, String city) {
		this.country = country;
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
