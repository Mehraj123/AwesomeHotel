package com.ah.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ah.entity.Review;
import com.ah.mv.HotelMV;
import com.ah.util.PageableInfo;
import com.ah.vm.HotelVM;

/**
 * @author Mehraj Malik
 * @version 1.0
 *
 */
public interface HotelService {

	PageableInfo<HotelMV> getAll(Pageable pageable);

	HotelMV getById(String hotelId);

	PageableInfo<HotelMV> getByMaxPrice(int maxPrice, Pageable pageable);

	HotelMV add(HotelVM hotelVM);

	HotelMV update(HotelVM hotelVM);

	Boolean delete(String hotelId);

	List<HotelMV> getByCityName(String cityName);

	List<HotelMV> getByRating(double rating);

	List<HotelMV> getByHotelNameStartsWith(String hotelName);

	List<HotelMV> getRandom(int size);

	HotelMV getByName(String name);

	List<HotelMV> getByCommentUserName(String userName);

	List<HotelMV> getReviewByHotelId(String id);

	HotelMV addReviewToHotel(String id, Review review);

	Boolean clearCache();

}
