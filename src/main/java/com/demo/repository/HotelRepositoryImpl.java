package com.demo.repository;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.demo.entity.Hotel;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author Mehraj Malik
 *
 */
public class HotelRepositoryImpl implements HotelCustomRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Hotel> findByCommentUserName(String userName) {
		Query query = new Query(Criteria.where("reviews.userName").in(userName));
		query.fields().include("reviews.$");
		return mongoTemplate.find(query, Hotel.class);
	}

	@Override
	public List<Hotel> findByRatingGreaterThan(int rating) {
		Query query = new Query(Criteria.where("reviews.rating").gte(rating));
		return mongoTemplate.find(query, Hotel.class);

	}

	/**
	 * Finds Hotels starts with provided string(Case insensitive)
	 * 
	 * @author Mehraj Malik
	 */
	@Override
	public List<Hotel> findByHotelNameStartsWith(String startsWith) {
		Query query = new Query();
		// ^ means startswith
		query.addCriteria(Criteria.where("name").regex(Pattern.compile("^" + startsWith, Pattern.CASE_INSENSITIVE)));
		return mongoTemplate.find(query, Hotel.class);
	}

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public List<Hotel> getRandomDocument(int size) {
		DBObject dbObject = new BasicDBObject("$sample", new BasicDBObject("size", size));
		CustomAggregation customAggregation = new CustomAggregation(dbObject);
		Aggregation aggregation = Aggregation.newAggregation(customAggregation);
		AggregationResults<Hotel> results = mongoOperations.aggregate(aggregation, "hotel", Hotel.class);
		return results.getMappedResults();
	}

}
