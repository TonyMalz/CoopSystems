package de.cmlab.assignments.cscw.two;
/*
 * This interface defines specific methods of a observer working according to the observer pattern (see Gamma et al. (1994)). A subject has a name and an associated observer.
 */
public interface Observer {
	/*
	 * The observer is notified by the subject with this method.
	 * 
	 * @return true on correct reception
	 */
	boolean stateChanged();
}
