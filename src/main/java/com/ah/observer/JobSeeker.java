package com.ah.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mehraj Malik
 *
 */
public class JobSeeker implements Observer<Job> {

	private static final Logger log = LoggerFactory.getLogger(JobSeeker.class);

	private String name;

	public JobSeeker(String name) {
		this.name = name;
	}

	@Override
	public void update(Subject<Job> subject, Job job) {
		log.info("{} got notified for {}", name, job);
	}

}
