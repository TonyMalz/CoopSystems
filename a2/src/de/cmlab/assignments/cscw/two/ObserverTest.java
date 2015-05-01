package de.cmlab.assignments.cscw.two;

public class ObserverTest {
	public static void main(String[] args) {
		Subject sub = new SubjectImpl();

		Observer o1 = new ObserverImpl(sub);
		Observer o2 = new ObserverImpl(sub);
		Observer o3 = new ObserverImpl(sub);
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
