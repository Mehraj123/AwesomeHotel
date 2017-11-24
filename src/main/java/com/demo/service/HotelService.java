package com.demo.service;

import java.util.List;

import com.demo.mv.HotelMV;
import com.demo.vm.HotelVM;

/**
 * @author Mehraj Malik
 * @version 1.0
 *
 */
public interface HotelService {

	List<HotelMV> getAll();

	HotelMV getById(String hotelId);

	List<HotelMV> getByMaxPrice(int maxPrice);

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

}
