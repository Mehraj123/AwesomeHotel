package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.Hotel;
import com.demo.repository.HotelRepository;
/***
 * 
 * @author Mehraj Malik
 *
 */
@Controller
public class ViewController {
	
	@Autowired
	private HotelRepository hotelRepository;

	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("username","Iron Man");
		List<Hotel> hotelList  = hotelRepository.findAll();
		model.addAttribute("hotelList",hotelList);
		return "index";
	}
}
