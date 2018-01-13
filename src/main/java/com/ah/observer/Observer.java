package com.ah.observer;

/**
 * An observer is an Object who is observing {@code Subject}'s state
 * 
 * @author Mehraj Malik
 * @version 1.0
 */
public interface Observer<T> {
	public void update(Subject<T> subject, T data);
}
