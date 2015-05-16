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

		System.out.print("Adding Observer " + o1 + " => \t");
		System.out.println(sub.addObserver(o1) == true);
		System.out.print("Adding Observer " + o2 + " => \t");
		System.out.println(sub.addObserver(o2) == true);
		System.out.print("Adding Observer " + o2 + " => \t");
		System.out.println(sub.addObserver(o2) == true);
		System.out.print("Adding Observer " + o3 + " => \t");
		System.out.println(sub.addObserver(o3) == true);

		System.out.println();
		System.out.print("Removing Observer " + o3+ " => \t");
		System.out.println(sub.removeObserver(o3) == true);
		System.out.print("Removing Observer " + o3 + " => \t");
		System.out.println(sub.removeObserver(o3) == true);

		System.out.println();
		System.out.println("Altering state by observer " + o1);
		o1.alterState();
		
		o1.printState();
		o2.printState();
		o3.printState();

		System.out.println();
		System.out.println("Altering state by observer " + o2);
		o2.alterState();
		
		o1.printState();
		o2.printState();

		System.out.println();
		System.out.print("Adding Observer " + o3 + " => \t");
		System.out.println(sub.addObserver(o3) == true);

		System.out.println();
		System.out.println("Altering state by observer " + o1);
		o1.alterState();
		
		o1.printState();
		o2.printState();
		o3.printState();

		System.out.println();
		System.out.println("Altering state by observer " + o3);
		o3.alterState();
		
		o1.printState();
		o2.printState();
		o3.printState();

	}
}
