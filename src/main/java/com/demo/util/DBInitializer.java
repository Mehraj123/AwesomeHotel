package com.demo.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.entity.Hotel;
import com.demo.repository.HotelRepository;

@Component
public class DBInitializer implements CommandLineRunner{
	
private static Logger logger = LoggerFactory.getLogger(DBInitializer.class);
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public void run(String... arg0) throws Exception {
		List<Hotel> hotelList = DBUtil.initDB();
		
		this.hotelRepository.deleteAll();
		this.hotelRepository.save(hotelList);
		
		logger.info("DB Initialized");
	}

}
