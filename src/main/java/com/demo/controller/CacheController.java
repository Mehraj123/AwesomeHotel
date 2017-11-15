package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.CachableService;

/**
 * @author Mehraj Malik
 *
 */
@RestController
@RequestMapping("/cache/")
public class CacheController {

	@Autowired
	private CachableService cachableService;

	@GetMapping("/names")
	public String get() {
		return cachableService.getName().getName();
	}

	@GetMapping("/update/{name}")
	public String update(@PathVariable("name") String name) {
		return cachableService.updateArmor(name).getName();
	}

}
