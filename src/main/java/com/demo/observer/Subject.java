package com.demo.observer;

/**
 * A subject is an Object whose state is being observed
 * 
 * @author Mehraj Malik
 * @version 1.0
 */
public interface Subject {

	public boolean registerObserver(Observer o);

	public boolean removeObserver(Observer o);

	public void notifyAllObservers();
}
