package com.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Hotel;

/**
 * Mongo repository for {@code Hotel}
 * 
 * @author Mehraj Malik
 * @version 1.0
 */
@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>, HotelCustomRepository {

	public Hotel findById(String id);

	public List<Hotel> findByPricePerNightLessThanEqual(int maxPrice);

	public List<Hotel> findByAddressCityIgnoreCaseLike(String city);

	public List<Hotel> findByNameIgnoreCaseLike(String name);

	public List<Hotel> findByReviewsUserName(String userName);

	public Hotel findByName(String name);
}
