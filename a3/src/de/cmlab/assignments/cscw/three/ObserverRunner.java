package de.cmlab.assignments.cscw.three;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * The purpose of this class is the basic testing of the Observer pattern
 * implementation
 *
 * @author Tony Malzhacker
 * @since 2015-06-07
 */
public class ObserverRunner {

	/**
	 * Runs the test
	 * 
	 * @param args
	 *            No args
	 */
	public static void main(String[] args) {

		Subject sub = new SubjectImpl();

		// start 3 observer threads
		ExecutorService pool = Executors.newCachedThreadPool();
		pool.submit(new ObserverImpl("hans1", sub));
		pool.submit(new ObserverImpl("hans2", sub));
		pool.submit(new ObserverImpl("hans3", sub));

		pool.shutdown();

		try {
			pool.awaitTermination(1, TimeUnit.MINUTES);

		} catch (InterruptedException e) {
		}
		System.out.println("Final state: " + sub.getState());
	}
}
