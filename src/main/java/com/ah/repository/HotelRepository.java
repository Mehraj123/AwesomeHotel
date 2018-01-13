package com.ah.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ah.entity.Hotel;
import com.ah.repository.custom.HotelCustomRepository;

/**
 * Mongo repository for {@code Hotel}
 * 
 * @author Mehraj Malik
 * @version 1.0
 */
@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>, HotelCustomRepository {

	public Hotel findById(String id);

	public Page<Hotel> findByPricePerNightLessThanEqual(int maxPrice, Pageable pageable);

	public List<Hotel> findByAddressCityIgnoreCaseLike(String city);

	public List<Hotel> findByNameIgnoreCaseLike(String name);

	public List<Hotel> findByReviewsUserName(String userName);

	public Hotel findByName(String name);
}
