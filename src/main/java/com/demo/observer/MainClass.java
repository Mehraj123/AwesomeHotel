package com.demo.observer;

/**
 * @author Mehraj Malik
 *
 */
public class MainClass {

	public static void main(String[] args) {
		HeadHunter hh = new HeadHunter();
		hh.registerObserver(new JobSeeker("Mike"));
		hh.registerObserver(new JobSeeker("Justin"));
		hh.registerObserver(new JobSeeker("El"));

		// Each time, a new job is added, all registered job seekers will get noticed.
		hh.addJob("Google Job");
		hh.addJob("Yahoo Job");
	}
}
