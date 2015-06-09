package de.cmlab.assignments.cscw.three;

import java.util.Random;

/**
 * Implementation of the ObserverInterface
 *
 * @author Tony Malzhacker
 * @since 2015-06-07
 */
public class ObserverImpl
		implements
			Observer,
			Runnable,
			Comparable<ObserverImpl> {
	private final Subject subject;
	private Integer currentState;
	private final String observerName;

	/**
	 * Initiates an observer with name and a subject
	 * 
	 * @param observerName
	 *            Name of the Observer
	 * @param subject
	 *            Subject to subscribe to
	 */
	public ObserverImpl(String observerName, Subject subject) {
		this.observerName = observerName;
		this.subject = subject;
		if (subject != null) {
			subject.addObserver(this);
		}
	}

	/**
	 * Locally alters the state and updates the subject
	 */
	public void alterState() {

		if (subject != null) {
			// acquire lock from 'subject' because we read AND write to shared
			// resource 'state' and thus have to block other threads from doing
			// so concurrently to avoid race conditions
			synchronized (subject) {
				currentState = (Integer) subject.getState();
				System.out.println("<< Thread " + observerName + " got state "
						+ currentState);
				System.out.println(">> Thread " + observerName
						+ " altering state to " + (++currentState));
				subject.setState(currentState);
			}

		}
	}

	/**
	 * Prints out the current state on the standard out
	 */
	public void printState() {
		System.out.println(" current state of " + observerName + " => "
				+ currentState);
	}

	/**
	 * The observer is notified by the subject with this method.
	 *
	 * @return true if the new state could be acquired
	 */
	@Override
	public boolean stateChanged() {
		if (subject != null) {
			currentState = (Integer) subject.getState();
			System.out.println("Thread " + observerName
					+ " got notified state changed to: " + currentState);
			return true;
		}
		return false;
	}

	/**
	 * Returns the name of the observer
	 *
	 * @return the name
	 */
	@Override
	public String toString() {
		return this.observerName;
	}

	@Override
	public void run() {
		Random r = new Random();

		while (true) {
			int ms = r.nextInt(100);

			try {

				System.out.println("Observer thread " + observerName
						+ " sleeping for " + ms + " ms");
				Thread.sleep(ms);
			} catch (InterruptedException e) {
			}
			alterState();
			printState();

			// exit with p = 0.5
			if (ms % 2 == 0) {
				break;
			}

		}

		if (subject != null) {
			System.out.println("Observer thread " + observerName
					+ " unsubscribing from subject");
			subject.removeObserver(this);
		}

		System.out.println("Observer thread " + observerName
				+ " finished with final sate: " + currentState);
	}

	@Override
	public int compareTo(ObserverImpl o) {
		return o.observerName.compareTo(this.observerName);
	}
}
