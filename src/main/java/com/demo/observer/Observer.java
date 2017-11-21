package com.demo.observer;

/**
 * An observer is an Object who is observing {@code Subject}'s state
 * 
 * @author Mehraj Malik
 * @version 1.0
 */
public interface Observer {
	public void update(Subject s);
}
