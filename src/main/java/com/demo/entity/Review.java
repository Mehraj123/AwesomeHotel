package com.demo.entity;

import lombok.Data;

@Data
public class Review {
	private String id;
	private String userName;
	private int rating;
	private boolean isApproved;

	public Review() {
	}

	public Review(String userName, int rating, boolean isApproved) {
		this.userName = userName;
		this.rating = rating;
		this.isApproved = isApproved;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	/**
	 * @author Mehraj Malik
	 */
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
}