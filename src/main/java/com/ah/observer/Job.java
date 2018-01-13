package com.ah.observer;

/**
 * @author Mehraj Malik
 *
 */
public class Job {

	private String name;

	public Job(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Job [name=" + name + "]";
	}

}
