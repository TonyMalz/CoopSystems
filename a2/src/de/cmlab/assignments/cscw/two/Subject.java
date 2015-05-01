package de.cmlab.assignments.cscw.two;
/*
 * This interface defines specific methods of a subject working according to the observer pattern (see Gamma et al. (1994)). A subject has a name and an associated observer.
 */
public interface Subject {

	/*
	 * Adds the given observer to the set of observers. It returns true if this
	 * registration was successful. True is only returned if the observer was
	 * not contained by the set prior to the call of the method.
	 * 
	 * @param o observer to be registered.
	 * 
	 * @return true only if observer was not contained by the set
	 */
	public boolean addObserver(Observer o);

	/*
	 * Propagating state information according to the pull model. After being
	 * notified by the subject, the observers can get the relevant information
	 * regarding the state change.
	 * 
	 * @return information regarding the state change
	 */
	public Object getState();

	/*
	 * Broadcasts a changed state of the subject to all other registered
	 * observers. In order to receive this information, a observer needs to be
	 * registered to the subjects set.
	 */
	public void notifyObservers();

	/*
	 * Removes the given observer from the set of observers and returns true if
	 * this removal was successful. True is only return if the given observer
	 * was contained by the set
	 * 
	 * @param o observer to be removed.
	 * 
	 * @return true only if the colleague was contained by the set
	 */
	public boolean removeObserver(Observer o);

	/*
	 * Propagating state information according to the pull model. Before
	 * notifying the subject, an observer can propagate the relevant information
	 * regarding the state changes he performed on the subject.
	 * 
	 * @param state information regarding the state change
	 */
	public void setState(Object state);
}
