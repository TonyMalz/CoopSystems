package de.cmlab.assignments.cscw.two;

import java.util.HashSet;
import java.util.Set;

public class SubjectImpl implements Subject {
	private final Set<Observer> observers = new HashSet<Observer>(10);
	private Object state;

	@Override
	public boolean addObserver(Observer o) {
		return observers.add(o);
	}

	@Override
	public Object getState() {
		return state;
	}
	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.stateChanged();
		}
	}

	@Override
	public boolean removeObserver(Observer o) {
		return observers.remove(o);
	}

	@Override
	public void setState(Object state) {
		this.state = state;
		notifyObservers();
	}

}
