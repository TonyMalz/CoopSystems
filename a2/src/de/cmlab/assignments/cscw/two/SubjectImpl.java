package de.cmlab.assignments.cscw.two;

import java.util.HashSet;
import java.util.Set;
/**
 * Implementation of the SubjectInterface
 *
 * @author Tony Malzhacker
 */
public class SubjectImpl implements Subject {
	private final Set<Observer> observers = new HashSet<Observer>(10);
	private Object state;

	/**
	 * Initiates an subject with an initial state
	 */
	public SubjectImpl(){
		state = new String("init");
	}

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
