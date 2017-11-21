package com.demo.observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * An implementation of {@code Subject}
 * 
 * @author Mehraj Malik
 * @version 1.0
 */
public class HeadHunter implements Subject {

	private Set<Observer> observers = new HashSet<>();
	private List<String> jobs = new ArrayList<>();

	/**
	 * Registers an {@code Observer}
	 */
	@Override
	public boolean registerObserver(Observer o) {
		return observers.add(o);
	}

	@Override
	public boolean removeObserver(Observer o) {
		return observers.remove(o);
	}

	@Override
	public void notifyAllObservers() {
		for (Observer o : observers) {
			o.update(this);
		}
	}

	@Override
	public String toString() {
		return jobs.toString();
	}

	public void addJob(String job) {
		this.jobs.add(job);
		notifyAllObservers();
	}

	public List<String> getJobs() {
		return jobs;
	}

}
