package de.cmlab.assignments.cscw.two;
/**
 * The purpose of this class is the basic testing of the Observer pattern implementation
 *
 * @author Tony Malzhacker
 */
public class ObserverTest {

	/**
	 * Runs the test
	 * 
	 * @param args No args
	 */
	public static void main(String[] args) {
		Subject sub = new SubjectImpl();

		Observer o1 = new ObserverImpl("hans1",sub);
		Observer o2 = new ObserverImpl("hans2",sub);
		Observer o3 = new ObserverImpl("hans3",sub);
		sub.addObserver(o1);
		sub.addObserver(o2);
		sub.addObserver(o2);
		sub.addObserver(o3);

		sub.setState("Init State");
		sub.removeObserver(o3);
		sub.removeObserver(o3);
		sub.setState("New State");
	}
}
