package com.demo.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Mehraj Malik
 *
 */
@Service
public class CachableService {

	private static final Logger log = LoggerFactory.getLogger(CachableService.class);

	Armor armor = new Armor();

	@Cacheable(value = "hotelCache")
	public List<String> getAllNames() {
		log.info("Executing getAllNames");
		return Arrays.asList("A", "B", "C");
	}

	@Cacheable(value = "hotelCache")
	public Armor getName() {
		log.info("Preparing armor for the first time");
		armor.setName("Mark 1");
		return armor;
	}

	@CachePut(value = "hotelCache")
	public Armor updateArmor(String armorName) {
		log.info("Updating armor capabilities...");
		armor.setName(armorName);
		return armor;
	}

	@CacheEvict(value = "hotelCache")
	public void clearCache() {
		log.info("clearing the hotelCache ");
	}
}
