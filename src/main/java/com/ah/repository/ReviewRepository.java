package com.ah.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ah.entity.Review;

/**
 * @author user
 *
 */
public interface ReviewRepository extends MongoRepository<Review, String>{
	
	public List<Review> findById(String id);

}
