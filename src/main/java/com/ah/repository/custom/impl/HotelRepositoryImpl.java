package com.ah.repository.custom.impl;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.ah.entity.Hotel;
import com.ah.entity.Review;
import com.ah.repository.CustomAggregation;
import com.ah.repository.custom.HotelCustomRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

/**
 * @author Mehraj Malik
 *
 */
public class HotelRepositoryImpl implements HotelCustomRepository {

	private static final Logger log = LoggerFactory.getLogger(HotelRepositoryImpl.class);

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public List<Hotel> findByCommentUserName(String userName) {
		Query query = new Query(Criteria.where("reviews.userName").in(userName));
		// query.fields().include("reviews.$");
		return mongoTemplate.find(query, Hotel.class);
	}

	@Override
	public List<Hotel> findByRatingGreaterThanEqual(double rating) {
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

	@Override
	public List<Hotel> getRandomDocument(int size) {
		DBObject dbObject = new BasicDBObject("$sample", new BasicDBObject("size", size));
		CustomAggregation customAggregation = new CustomAggregation(dbObject);
		Aggregation aggregation = Aggregation.newAggregation(customAggregation);
		AggregationResults<Hotel> results = mongoOperations.aggregate(aggregation, "hotel", Hotel.class);
		return results.getMappedResults();
	}

	@Override
	public List<Hotel> getReviewByHotelId(String hotelId) {
		ObjectId objectId = new ObjectId(hotelId);
		MatchOperation match = Aggregation.match(Criteria.where("_id").is(new ObjectId(hotelId)));
		// ProjectionOperation projection = Aggregation.project("reviews");
		Aggregation aggregation = Aggregation.newAggregation(match);
		AggregationResults<Hotel> results = mongoOperations.aggregate(aggregation, "hotel", Hotel.class);
		// return results.getMappedResults();
		Query query = new Query();
		query.fields().include("reviews");
		query.addCriteria(Criteria.where("id").is(hotelId));
		List<Hotel> hotels = mongoOperations.find(query, Hotel.class);
		return hotels;
	}

	/**
	 * Add review to {@code Hotel}
	 * 
	 * @param hotelId
	 *            Id of hotel
	 * @param review
	 *            Review to be added
	 */
	@Override
	public String updateReview(String hotelId, Review review) {
		Query byID = new Query();
		byID.addCriteria(Criteria.where("id").is(hotelId));
		DBObject value = new BasicDBObject("rating", review.getRating()).append("id", UUID.randomUUID())
				.append("description", review.getDescription()).append("isApproved", review.getIsApproved())
				.append("user",
						new BasicDBObject("id", review.getUser().getId()).append("name", review.getUser().getName()));
		WriteResult writeResult = mongoOperations.updateFirst(byID, new Update().addToSet("reviews", value),
				Hotel.class);
		log.info("isUpdateOfExisting {} ", writeResult.isUpdateOfExisting());
		log.info("wasAcknowledged {} ", writeResult.wasAcknowledged());
		Object updatedId = writeResult.getUpsertedId();
		log.info("getUpsertedId {} ", updatedId);
		return updatedId + "";
	}

}
