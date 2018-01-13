package com.demo.observer;

/**
 * A subject is an Object whose state is being observed
 * 
 * @author Mehraj Malik
 * @version 1.0
 */
public interface Subject<T> {

	public boolean registerObserver(Observer<T> observer);

	public boolean removeObserver(Observer<T> observer);

	public void notifyAllObservers(T data);
}
