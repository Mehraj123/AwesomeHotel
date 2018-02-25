package com.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.entity.Review;

/**
 * @author demo
 *
 */
public interface ReviewRepository extends MongoRepository<Review, String>{
	
	public List<Review> findById(String id);

}
