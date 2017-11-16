package com.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Hotel;
import com.demo.entity.Review;
import com.demo.repository.HotelRepository;
import com.demo.repository.ReviewRepository;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	private static final Logger log = LoggerFactory.getLogger(HotelController.class);

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@GetMapping("/all")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		return new ResponseEntity<>(this.hotelRepository.findAll(), HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hotel> findById(@PathVariable("id") String id) {
		return new ResponseEntity<>(this.hotelRepository.findById(id), HttpStatus.FOUND);
	}

	@GetMapping("/price/{maxPrice}")
	public ResponseEntity<List<Hotel>> findByPricePErNight(@PathVariable("maxPrice") int maxPrice) {
		return new ResponseEntity<>(hotelRepository.findByPricePerNightLessThan(maxPrice), HttpStatus.FOUND);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insert(@RequestBody Hotel hotel) {
		Hotel insertedHotel = this.hotelRepository.insert(hotel);
		log.info("Inserted Hotel : " + insertedHotel.getName() + " - " + insertedHotel.getId());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Void> update(@RequestBody Hotel hotel) {
		Hotel updatedHotel = this.hotelRepository.save(hotel); // upsert
		log.info("Updated Hotel : ", updatedHotel.getName() + " - " + updatedHotel.getId());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") String id) {
		this.hotelRepository.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/city/{city}")
	public ResponseEntity<List<Hotel>> findByCity(@PathVariable(name = "city") String city) {
		List<Hotel> list = this.hotelRepository.findByAddressCityIgnoreCase(city);
		log.info("ByCity : ", list);
		return new ResponseEntity<>(list, HttpStatus.FOUND);
	}

	@GetMapping("/user/{user}")
	public ResponseEntity<List<Hotel>> findByRating(@PathVariable(name = "user") String user) {
		List<Hotel> list = this.hotelRepository.findByCommentUserName(user);
		log.info("By userName : ", list);
		return new ResponseEntity<>(list, HttpStatus.FOUND);
	}

	@GetMapping("/rating/{rating}")
	public ResponseEntity<List<Hotel>> findByReviewRating(@PathVariable(name = "rating") int rating) {
		List<Hotel> list = this.hotelRepository.findByRatingGreaterThan(rating);
		log.info("Byrating : ", list);
		return new ResponseEntity<>(list, HttpStatus.FOUND);
	}

	@PostMapping("/review/")
	public ResponseEntity<Void> insertReview(@RequestBody Review review) {
		Review insertedHotel = this.reviewRepository.save(review);
		log.info("Inserted Hotel : ", insertedHotel.getUserName() + " - " + insertedHotel.getId());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/like/{startswith}")
	public ResponseEntity<List<Hotel>> findByNameLike(@PathVariable(name = "startswith") String startswith) {
		List<Hotel> list = this.hotelRepository.findByHotelNameStartsWith(startswith);
		log.info("startsWith : ", list);
		return new ResponseEntity<>(list, HttpStatus.FOUND);
	}

	@GetMapping("/random/{size}")
	public ResponseEntity<List<Hotel>> getRandom(@PathVariable(name = "size") int size) {
		List<Hotel> list = this.hotelRepository.getRandomDocument(size);
		log.info("Random Documents : {}", list);
		return new ResponseEntity<>(list, HttpStatus.FOUND);
	}
}
