package de.cmlab.assignments.cscw.two;
/**
 * Implementation of the ObserverInterface
 *
 * @author Tony Malzhacker
 * @since   2015-05-07
 */
public class ObserverImpl implements Observer {
	private final Subject subject;
	private Object currentState;
	private String observerName;
	private static int stateChanged = 0;

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
		currentState = new String(observerName + " no of state changes: " + (++stateChanged));
		if (subject != null) {
			subject.setState(currentState);
		}
	}

	/**
	 * Prints out the current state on the standard out
	 */
	public void printState(){
		System.out.println(observerName + " current state: " + currentState);
	}

	/**
	 * The observer is notified by the subject with this method.
	 */
	@Override
	public boolean stateChanged() {
		if (subject != null) {
			currentState = subject.getState();
			return true;
		}
		return false;
	}

}
