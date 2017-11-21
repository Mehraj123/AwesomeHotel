package com.demo.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mehraj Malik
 *
 */
public class JobSeeker implements Observer {

	private static final Logger log = LoggerFactory.getLogger(JobSeeker.class);

	private String name;

	public JobSeeker(String name) {
		this.name = name;
	}

	@Override
	public void update(Subject s) {
		log.info("Got notified {} ", this.name);
		// print job list
		log.info("Subject {} ", s);
	}
}
