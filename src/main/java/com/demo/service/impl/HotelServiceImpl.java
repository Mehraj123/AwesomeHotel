package com.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.controller.HotelController;
import com.demo.entity.Hotel;
import com.demo.error.HotelExceptionSupplier;
import com.demo.mv.HotelMV;
import com.demo.repository.HotelRepository;
import com.demo.service.HotelService;
import com.demo.vm.HotelVM;

/**
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

	@Override
	public List<HotelMV> getAll() {
		List<Hotel> hotels = hotelRepository.findAll();
		log.info("Finding all hotels : found {}", hotels.size());
		return Arrays.asList(modelMapper.map(hotels, HotelMV[].class));
	}

	@Override
	public HotelMV getById(String hotelId) {
		Hotel hotel = hotelRepository.findById(hotelId);
		if (hotel == null) {
			throw HotelExceptionSupplier.NO_HOTEL_FOUND_BY_ID.get();
		}
		return modelMapper.map(hotel, HotelMV.class);
	}

	@Override
	public List<HotelMV> getByMaxPrice(int maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelMV add(HotelVM hotelVM) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelMV update(HotelVM hotelVM) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String hotelId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HotelMV> getByCityName(String cityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelMV> getByRating(double rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelMV> getByHotelNameStartsWith(String hotelName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelMV> getRandom(int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
