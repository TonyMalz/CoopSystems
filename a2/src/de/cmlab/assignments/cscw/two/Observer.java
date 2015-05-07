package de.cmlab.assignments.cscw.two;
/**
 * This interface defines specific methods of a observer working according to the observer pattern (see Gamma et al. (1994)). A subject has a name and an associated observer.
 *
 * @author Tony Malzhacker
 */
public interface Observer {
	/**
	 * The observer is notified by the subject with this method.
	 * The state will be updated in this method via the reference to the subject after notification in order to stay in sync with the subject.
	 * @return true on correct reception
	 */
	boolean stateChanged();
}
