package de.cmlab.assignments.cscw.two;

public class ObserverImpl implements Observer {
	private final Subject subject;
	private Object currentState;

	public ObserverImpl(Subject subject) {
		this.subject = subject;
	}

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
