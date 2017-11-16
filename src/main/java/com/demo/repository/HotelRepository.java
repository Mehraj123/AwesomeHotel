package com.demo.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>, HotelCustomRepository {

	public Hotel findById(String id);

	public List<Hotel> findByPricePerNightLessThan(int maxPrice);

	@Cacheable()
	@Query(value = "{address.city:?0}")
	public List<Hotel> findByCity(String city);

	@Cacheable
	public List<Hotel> findByAddressCityIgnoreCase(String city);

	@Cacheable
	public List<Hotel> findByReviewsUserName(String userName);

}
