package de.cmlab.assignments.cscw.two;
/**
 * Implementation of the ObserverInterface
 *
 * @author Tony Malzhacker
 */
public class ObserverImpl implements Observer {
	private final Subject subject;
	private Object currentState;
	private String observerName;

	/**
	 * Initiates an observer with name and a subject
	 * 
	 * @param observerName Name of the Observer
	 * @param subject Subject to subscribe to
	 */
	public ObserverImpl(String observerName, Subject subject) {
		this.subject = subject;
		this.observerName = observerName;
	}

	/**
	 * Locally alters the state and updates the subject
	 */
	public void alterState(){

	}

	/**
	 * Prints out the current state on the standard out
	 */
	public void printState(){

	}

	/**
	 * The observer is notified by the subject with this method.
	 */
	@Override
	public boolean stateChanged() {
		if (subject != null) {
			currentState = subject.getState();
			System.out.println("State changed: " + currentState);
			return true;
		}
		return false;
	}

}
