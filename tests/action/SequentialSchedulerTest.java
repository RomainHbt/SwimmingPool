package action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.ActionFinishedException;

public class SequentialSchedulerTest {

	private Scheduler sc;

	@Before
	public void setUp() throws Exception {
		this.sc = new SequentialScheduler();
	}

	@Test
	public void scheduler() {
		Action a1 = new ForseeableAction(2);
		Action a2 = new ForseeableAction(1);
		
		sc.addAction(a1);
		sc.addAction(a2);
		
		assertTrue(a1.isReady());
		assertTrue(a2.isReady());
		
		try {
			sc.doStep();
		} catch (ActionFinishedException e) {
			fail("Exception Catched");
		}
		
		assertTrue(a1.isInProgress());
		assertTrue(a2.isReady());
		
		try {
			sc.doStep();
		} catch (ActionFinishedException e) {
			fail("Exception Catched");
		}
		
		assertTrue(a1.isFinished());
		assertTrue(a2.isReady());
		
		try {
			sc.doStep();
		} catch (ActionFinishedException e) {
			fail("Exception Catched");
		}
		
		assertTrue(a1.isFinished());
		assertTrue(a2.isFinished());
	}
	
	@Test
	public void schedulerWithScheduler() {
		Scheduler subSc = new SequentialScheduler();
		Action a = new ForseeableAction(2);
		
		subSc.addAction(a);
		sc.addAction(subSc);
		
		assertTrue(a.isReady());
		assertTrue(subSc.isReady());
		
		try {
			sc.doStep();
		} catch (ActionFinishedException e) {
			fail("Exception Catched");
		}
		
		assertTrue(a.isInProgress());
		assertTrue(subSc.isInProgress());
		
		try {
			sc.doStep();
		} catch (ActionFinishedException e) {
			fail("Exception Catched");
		}
		
		assertTrue(a.isFinished());
		assertTrue(subSc.isFinished());
	}
}
