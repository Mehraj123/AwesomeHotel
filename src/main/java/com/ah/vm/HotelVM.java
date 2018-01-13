package com.ah.vm;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.ah.entity.Address;
import com.ah.entity.Review;

/**
 * Veiw model for {@code Hotel}
 * 
 * @author Mehraj Malik
 * @version 1.0
 *
 */

public class HotelVM {

	private String id;
	@NotBlank(message = "Hotel Name cannot be blank")
	@Size(min = 3, max = 50, message = "Hotel name length must be between 3-50")
	private String name;
	@Range(min = 0, max = 100000, message = "Price Per Night must be between 0-100000")
	private int pricePerNight;
	private Address address;
	private Review review;
	@Range(min = 0, max = 5, message = "Rating must be between 0-5")
	private Double rating;
	private LocalDateTime registeredDateTime;

	public LocalDateTime getRegisteredDateTime() {
		return registeredDateTime;
	}

	public void setRegisteredDateTime(LocalDateTime registeredDateTime) {
		this.registeredDateTime = registeredDateTime;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

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
