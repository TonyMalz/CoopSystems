package de.cmlab.assignments.cscw.three;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
/**
 * Implementation of the SubjectInterface
 *
 * @author Tony Malzhacker
 * @since 2015-06-07
 */
public class SubjectImpl implements Subject {
	private final Set<Observer> observers = new ConcurrentSkipListSet<Observer>();
	private volatile Object state;

	/**
	 * Initiates an subject with an initial state
	 */
	public SubjectImpl() {
		state = new Integer(0);
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
