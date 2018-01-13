package com.ah.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ah.entity.Hotel;
import com.ah.repository.HotelRepository;

@Component
public class DBInitializer {
	
private static Logger logger = LoggerFactory.getLogger(DBInitializer.class);
	

	/*@Override
	public void run(String... arg0) throws Exception {
		List<Hotel> hotelList = DBUtil.initDB();
		
		this.hotelRepository.deleteAll();
		this.hotelRepository.save(hotelList);
		
		logger.info("DB Initialized");
	}*/

}
