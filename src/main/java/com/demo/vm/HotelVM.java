package com.demo.vm;

import org.hibernate.validator.constraints.NotEmpty;

import com.demo.entity.Address;
import com.demo.entity.Review;

/**
 * Veiw model for {@code Hotel}
 * 
 * @author Mehraj Malik
 * @version 1.0
 *
 */

public class HotelVM {

	private String id;
	@NotEmpty(message = "Hotel Name cannot be blank")
	private String name;
	private int pricePerNight;
	private Address address;
	private Review review;
	
	
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
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	
	
	
	
}
