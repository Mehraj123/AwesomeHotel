package com.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Mehraj Malik
 *
 */
@Component
public class TaskSchedular {

	private static final Logger log = LoggerFactory.getLogger(TaskSchedular.class);

	/*@Scheduled(fixedDelay = 5000)
	public void execute() {
		log.info("Now : {}", LocalDateTime.now());
	}*/

}
