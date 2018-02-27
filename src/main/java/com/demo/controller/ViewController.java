package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 
 * @author Mehraj Malik
 *
 */
@Controller
@RequestMapping("/")
public class ViewController {

	@RequestMapping
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/crud")
	public String afterLoginSuccess(){
        System.out.println("--- Calling CRUD");
	    return "hotelCRUD";
    }
}
