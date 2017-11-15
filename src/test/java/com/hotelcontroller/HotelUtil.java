package com.hotelcontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.demo.entity.Address;
import com.demo.entity.Hotel;
import com.demo.entity.Review;

public class HotelUtil {

	
public static List<Hotel> mockHotel(){
		
		Hotel godWin = new Hotel(
				"A",
				1000,
				new Address("India","Meerut"),
				Arrays.asList(new Review("Rahul",10,true))
				);
		
		Hotel signature = new Hotel(
				"B",
				900,
				new Address("India","Meerut"),
				Arrays.asList(new Review("Salman",8,true),new Review("Shahrukh",5,false))
				);
		
		Hotel goldenPalm = new Hotel(
				"C",
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

	public static Hotel getOneHotel(){
		return new Hotel(
				"My Hotel",
				800,
				new Address("India","Meerut"),
				Arrays.asList(new Review("Iron Man",5,true))
				); 
	}
	
	public static String getHotelJson(){
		return 
				"{\"name\":\"God Win\",\"pricePerNight\":1000,\"address\":{\"country\":\"India\",\"city\":\"Meerut\"},\"reviews\":[{\"userName\":\"Rahul\",\"rating\":10,\"approved\":true}]}";
	}
}
