package com.demo.repository;

import java.util.List;

import com.demo.entity.Hotel;

/**
 * @author Mehraj Malik
 *
 */
public interface HotelCustomRepository {

	public List<Hotel> findByCommentUserName(String userName);
	public List<Hotel> findByRatingGreaterThan(int rating);
}
