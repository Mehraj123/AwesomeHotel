package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<String> get() {
		return cachableService.getAllNames();
	}
}
