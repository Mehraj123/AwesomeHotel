package com.demo.service.impl;

import static com.demo.error.HotelExceptionSupplier.HOTELNAME_NOT_UNIQUE_EXCEPTION;
import static com.demo.error.HotelExceptionSupplier.HOTEL_DELETE_EXCEPTION;
import static com.demo.error.HotelExceptionSupplier.HOTEL_FETCH_EXCEPTION;
import static com.demo.error.HotelExceptionSupplier.HOTEL_SAVE_EXCEPTION;
import static com.demo.error.HotelExceptionSupplier.HOTEL_UPDATE_EXCEPTION;
import static com.demo.error.HotelExceptionSupplier.NO_HOTEL_FOUND_BY_ID_EXCEPTION;
import static com.demo.error.HotelExceptionSupplier.SIZE_CANNOT_BE_NEGATIVE_EXCEPTION;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.controller.HotelController;
import com.demo.entity.Hotel;
import com.demo.entity.Review;
import com.demo.error.CustomParameterizedException;
import com.demo.mv.HotelMV;
import com.demo.repository.HotelRepository;
import com.demo.service.HotelService;
import com.demo.util.PageInfo;
import com.demo.util.PageableInfo;
import com.demo.vm.HotelVM;

/**
 * An impementation for {@code HotelService}
 * 
 * @author Mehraj Malik
 * @version 1.0
 *
 */
@Service
public class HotelServiceImpl implements HotelService {

	private static final Logger log = LoggerFactory.getLogger(HotelController.class);

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Provides all available {@code Hotel}
	 * 
	 * @param pageable
	 *            Pageable object
	 * @throws HOTEL_FETCH_EXCEPTION
	 *             If something went wrong while fetching data from DB
	 * @return {@code List<HotelMV>}
	 */
	@Override
	public PageableInfo<HotelMV> getAll(Pageable pageable) {
		try {
			Page<Hotel> hotels = hotelRepository.findAll(pageable);
			PageableInfo<HotelMV> pageableInfo = new PageableInfo<>();
			if (!hotels.getContent().isEmpty()) {
				pageableInfo.setContent(Arrays.asList(modelMapper.map(hotels.getContent(), HotelMV[].class)));
			} else {
				pageableInfo.setContent(Collections.emptyList());
			}
			pageableInfo.setPageInfo(modelMapper.map(hotels, PageInfo.class));
			log.info("Finding all hotels : found {}", hotels.getContent().size());
			return pageableInfo;
		} catch (Exception e) {
			throw HOTEL_FETCH_EXCEPTION.get();
		}
	}

	/**
	 * Provides {@code Hotel} by Id
	 * 
	 * @param hotelId
	 *            Id of {@code Hotel}
	 * @throws NO_HOTEL_EXIST_WITH_ID_EXCEPTION
	 *             if no {@code Hotel} exists with provided id
	 * @throws HOTEL_FETCH_EXCEPTION
	 *             If something went wrong while fetching data from DB
	 */
	@Override
	public HotelMV getById(String hotelId) {
		try {
			log.info("Searching hotel by id {} ", hotelId);
			Hotel hotel = hotelRepository.findById(hotelId);
			if (hotel == null) {
				log.info("No hotel found by id {} ", hotelId);
				throw NO_HOTEL_FOUND_BY_ID_EXCEPTION.get();
			}
			log.info("Hotel found by id {} ", hotelId);
			return modelMapper.map(hotel, HotelMV.class);
		} catch (CustomParameterizedException e) {
			throw e;
		} catch (Exception e) {
			throw HOTEL_FETCH_EXCEPTION.get();
		}
	}

	/**
	 * Searches all hotel by maxPrice LessThanEqual
	 * 
	 * @param maxPrice
	 *            Maximum price
	 * @param pageable
	 *            Pageable object
	 * @throws HOTEL_FETCH_EXCEPTION
	 *             If something went wrong while fetching data from DB
	 */
	@Override
	public PageableInfo<HotelMV> getByMaxPrice(int maxPrice, Pageable pageable) {
		try {
			log.info("Finding by maxPrice {} {}", maxPrice, pageable);
			Page<Hotel> page = hotelRepository.findByPricePerNightLessThanEqual(maxPrice, pageable);
			List<Hotel> hotels = page.getContent();
			PageableInfo<HotelMV> pageableInfo = new PageableInfo<>();
			if (!hotels.isEmpty()) {
				log.info("found by maxPrice {}", hotels.size());
				pageableInfo.setContent(Arrays.asList(modelMapper.map(hotels, HotelMV[].class)));
			} else {
				log.info("found by maxPrice {}", hotels.size());
				pageableInfo.setContent(Collections.emptyList());
			}
			pageableInfo.setPageInfo(modelMapper.map(page, PageInfo.class));
			return pageableInfo;
		} catch (Exception e) {
			throw HOTEL_FETCH_EXCEPTION.get();
		}
	}

	/**
	 * Saves a Hotel into DB
	 * 
	 * @param hotelVM
	 *            HotelVm to be saved
	 * @throws HOTELNAME_NOT_UNIQUE_EXCEPTION
	 *             If some hotel already exist with the same ID
	 * @throws HOTEL_SAVE_EXCEPTION
	 *             If something went wrong while savinf hotel into DB
	 * 
	 */
	@Override
	public HotelMV add(HotelVM hotelVM) {
		try {
			if (getByName(hotelVM.getName()) == null) {
				hotelVM.setRegisteredDateTime(LocalDateTime.now(ZoneId.systemDefault()));
				Hotel hotel = hotelRepository.insert(modelMapper.map(hotelVM, Hotel.class));
				return modelMapper.map(hotel, HotelMV.class);
			}
			throw HOTELNAME_NOT_UNIQUE_EXCEPTION.get();
		} catch (CustomParameterizedException e) {
			throw e;
		} catch (Exception e) {
			throw HOTEL_SAVE_EXCEPTION.get();
		}
	}

	@Override
	public HotelMV update(HotelVM hotelVM) {
		try {
			getById(hotelVM.getId());
			Hotel hotel = hotelRepository.save(modelMapper.map(hotelVM, Hotel.class));
			return modelMapper.map(hotel, HotelMV.class);
		} catch (Exception e) {
			throw HOTEL_UPDATE_EXCEPTION.get();
		}
	}

	@Override
	public Boolean delete(String hotelId) {
		try {

		} catch (Exception e) {
			throw HOTEL_DELETE_EXCEPTION.get();
		}
		return false;
	}

	@Override
	public List<HotelMV> getByCityName(String cityName) {
		try {
			return Arrays.asList(
					modelMapper.map(hotelRepository.findByAddressCityIgnoreCaseLike(cityName), HotelMV[].class));
		} catch (Exception e) {
			throw HOTEL_FETCH_EXCEPTION.get();
		}
	}

	@Override
	public List<HotelMV> getByRating(double rating) {
		try {
			return Arrays
					.asList(modelMapper.map(hotelRepository.findByRatingGreaterThanEqual(rating), HotelMV[].class));
		} catch (Exception e) {
			throw HOTEL_FETCH_EXCEPTION.get();
		}
	}

	@Override
	public List<HotelMV> getByHotelNameStartsWith(String hotelName) {
		try {
			return Arrays.asList(modelMapper.map(hotelRepository.findByNameIgnoreCaseLike(hotelName), HotelMV[].class));
		} catch (Exception e) {
			throw HOTEL_FETCH_EXCEPTION.get();
		}
	}

	@Override
	public List<HotelMV> getRandom(int size) {
		try {
			if (size < 1) {
				throw SIZE_CANNOT_BE_NEGATIVE_EXCEPTION.get();
			}
			return Arrays.asList(modelMapper.map(hotelRepository.getRandomDocument(size), HotelMV[].class));
		} catch (CustomParameterizedException e) {
			throw e;
		} catch (Exception e) {
			throw HOTEL_FETCH_EXCEPTION.get();
		}
	}

	@Override
	public HotelMV getByName(String name) {
		try {
			Hotel hotel = hotelRepository.findByName(name);
			if (hotel != null) {
				return modelMapper.map(hotel, HotelMV.class);
			}
			return null;
		} catch (Exception e) {
			throw HOTEL_FETCH_EXCEPTION.get();
		}
	}

	/**
	 * Provides all the {@code Hotel}s on which a particular user has commented
	 * 
	 * @param userName
	 *            UserName of User
	 * @throws HOTEL_FETCH_EXCEPTION
	 *             if something went wrong while fetching data from DB
	 * 
	 */
	@Override
	public List<HotelMV> getByCommentUserName(String userName) {
		try {
			return Arrays.asList(modelMapper.map(hotelRepository.findByCommentUserName(userName), HotelMV[].class));
		} catch (Exception e) {
			throw HOTEL_FETCH_EXCEPTION.get();
		}
	}

	/**
	 * Provides all the {@code Review}s by hotel id
	 * 
	 * @param id
	 *            {@code Hotel} id
	 * @throws HOTEL_FETCH_EXCEPTION
	 *             if something went wrong while fetching data from DB
	 */
	@Override
	public List<HotelMV> getReviewByHotelId(String id) {
		HotelMV hotel = getById(id);
		try {
			return Arrays.asList(modelMapper.map(hotelRepository.getReviewByHotelId(id), HotelMV[].class));
		} catch (Exception e) {
			throw HOTEL_FETCH_EXCEPTION.get();
		}
	}

	/**
	 * Adds {@code Review} to a {@code Hotel}
	 * 
	 * @param id
	 *            Id of Hotel
	 * @param review
	 *            {@code ReviewMV} to be added
	 */
	@Override
	public HotelMV addReviewToHotel(String id, Review review) {
		HotelMV hotel = getById(id);
		// hotelRepository.updateReview(id, review);
		List<Review> reviews = hotel.getReviews();
		if (reviews == null) {
			reviews = new ArrayList<>();
		}
		review.setId(UUID.randomUUID().toString());
		reviews.add(review);
		hotel.setReviews(reviews);
		Hotel updatedHotel = hotelRepository.save(modelMapper.map(hotel, Hotel.class));
		return modelMapper.map(updatedHotel, HotelMV.class);
	}

}
