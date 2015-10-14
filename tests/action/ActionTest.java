package action;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import exceptions.ActionFinishedException;

public class ActionTest {

	private Action createAction(int timeToEnd){
		return new ForseeableAction(timeToEnd);
	}

	@Test
	public void isNotFinishedAtStart() {
		Action a = createAction(1);
		assertTrue(a.isReady());
		assertFalse(a.isInProgress());
		assertFalse(a.isFinished());
	}
	
	@Test
	public void isInProgressInMiddle() {
		Action a = createAction(2);
		try {
			a.doStep();
		} catch (ActionFinishedException e) {
			fail("Exception Catched");
		}
		assertFalse(a.isReady());
		assertTrue(a.isInProgress());
		assertFalse(a.isFinished());
	}

	@Test
	public void isFinishedAtEnd() {
		Action a = createAction(1);
		try {
			a.doStep();
		} catch (ActionFinishedException e) {
			fail("Exception Catched");
		}
		assertFalse(a.isReady());
		assertFalse(a.isInProgress());
		assertTrue(a.isFinished());
	}
	
	@Test(expected=ActionFinishedException.class)
	public void getActionFinishedException() throws ActionFinishedException {
		Action a = createAction(1);
		a.doStep();
		a.doStep();
	}
}
