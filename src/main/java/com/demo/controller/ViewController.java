package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
