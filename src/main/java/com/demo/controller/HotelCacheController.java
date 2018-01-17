package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.HotelService;
import com.demo.successcode.HotelSuccessCode;
import com.demo.util.CustomResponse;

/**
 * 
 * @author Devendra.Kumar
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/hotels")
public class HotelCacheController {

	@Autowired
	private HotelService hotelService;

	@GetMapping("/cache/clearAllCache/")
	public ResponseEntity<CustomResponse> clear() {
		return new ResponseEntity<>(new CustomResponse(HotelSuccessCode.HOTEL_FETCHED.getCode(),
				HotelSuccessCode.HOTEL_FETCHED.getMessage(), hotelService.clearCache(), null), HttpStatus.OK);
	}
}
