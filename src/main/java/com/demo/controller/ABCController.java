package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ABCController {

	@RequestMapping("/abc")
	public String sayHi(){
		return "Hi";
	}
}
