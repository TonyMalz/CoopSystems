package de.cmlab.assignments.cscw.two;
/**
 * The purpose of this class is the basic testing of the Observer pattern implementation
 *
 * @author Tony Malzhacker
 * @since   2015-05-07
 */
public class ObserverTest {

	/**
	 * Runs the test
	 * 
	 * @param args No args
	 */
	public static void main(String[] args) {
		Subject sub = new SubjectImpl();

		ObserverImpl o1 = new ObserverImpl("hans1",sub);
		ObserverImpl o2 = new ObserverImpl("hans2",sub);
		ObserverImpl o3 = new ObserverImpl("hans3",sub);

		sub.addObserver(o1);
		sub.addObserver(o2);
		sub.addObserver(o2);
		sub.addObserver(o3);


		sub.removeObserver(o3);
		sub.removeObserver(o3);

		o1.alterState();
		o2.alterState();

		o1.printState();
		o2.printState();
		o3.printState();

		o2.alterState();
		o1.printState();
		o1.alterState();

		o1.printState();
		o2.printState();
		o3.printState();
	}
}
