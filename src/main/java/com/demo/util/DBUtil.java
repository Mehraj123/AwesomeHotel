package com.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.demo.entity.Address;
import com.demo.entity.Hotel;
import com.demo.entity.Review;

public class DBUtil {
	public static List<Hotel> initDB(){
		
		Hotel godWin = new Hotel(
				"God Win",
				1000,
				new Address("India","Meerut"),
				Arrays.asList(new Review("Rahul",10,true))
				);
		
		Hotel signature = new Hotel(
				"Signature",
				900,
				new Address("India","Meerut"),
				Arrays.asList(new Review("Salman",8,true),new Review("Shahrukh",5,false))
				);
		
		Hotel goldenPalm = new Hotel(
				"Golden Palm",
				800,
				new Address("India","Meerut"),
				Arrays.asList(new Review("Hulk",5,true))
				);
		
		List<Hotel> hotelList = new ArrayList<>();
		hotelList.add(godWin);
		hotelList.add(goldenPalm);
		hotelList.add(signature);
		return hotelList;
		
	}
}
