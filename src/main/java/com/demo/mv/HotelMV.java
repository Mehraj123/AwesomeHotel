package com.demo.mv;

import java.util.List;

import com.demo.entity.Address;
import com.demo.entity.Review;

/**
 * @author Mehraj Malik
 * @version 1.0
 *
 */
public class HotelMV {

	private String id;
	private String name;
	private int pricePerNight;
	private Address address;
	private List<Review> reviews;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
