package com.demo.observer;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * An implementation of {@code Subject}
 * 
 * @author Mehraj Malik
 * @version 1.0
 */
public class HeadHunter implements Subject<Job> {

	private Set<Observer<Job>> observerSet = new LinkedHashSet<>();
	private List<Job> jobs = new ArrayList<>();

	@Override
	public boolean registerObserver(Observer<Job> observer) {
		return observerSet.add(observer);
	}

	@Override
	public boolean removeObserver(Observer<Job> observer) {
		return observerSet.remove(observer);
	}

	@Override
	public void notifyAllObservers(Job job) {
		for (Observer<Job> ob : observerSet) {
			ob.update(this, job);
		}
	}

	public void addJob(Job job) {
		jobs.add(job);
		notifyAllObservers(job);
	}

	public List<Job> getJobs() {
		return jobs;
	}

}
