package com.ah.repository.custom;

import java.util.List;

import com.ah.entity.Hotel;
import com.ah.entity.Review;

/**
 * @author Mehraj Malik
 * @version 1.0
 */
public interface HotelCustomRepository {

	public List<Hotel> findByCommentUserName(String userName);

	public List<Hotel> findByRatingGreaterThanEqual(double rating);

	public List<Hotel> findByHotelNameStartsWith(String startsWith);

	public List<Hotel> getRandomDocument(int size);

	public List<Hotel> getReviewByHotelId(String hotelId);
	
	public String updateReview(String hotelId, Review review);

}
