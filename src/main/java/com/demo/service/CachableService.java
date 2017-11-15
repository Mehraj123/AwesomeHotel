package com.demo.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Mehraj Malik
 *
 */
@Service
public class CachableService {

	private static final Logger log = LoggerFactory.getLogger(CachableService.class);

	@Cacheable(value = "hotelCache")
	public List<String> getAllNames() {
		log.info("Executing getAllNames");
		return Arrays.asList("A", "B", "C");
	}
}
