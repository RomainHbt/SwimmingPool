package action;

import exceptions.ActionFinishedException;


/**
 * General class for actions
 * @author dubois hembert
 */

public abstract class Action
{
	
	private boolean isReady;
	private boolean isInitialized;
	
	public Action() {
		this.isReady = true;
		this.isInitialized = true;
	}

	/**
	 * Return true if the action is initialized and ready (not begun)
	 * @return true if the action is ready, false if not
	 */
	public boolean isReady() {
		return this.isInitialized && this.isReady;
	}
	
	
	/**
	 * Return true if the action is initialized and begun
	 * @return true if the action started, false if not
	 */
	public boolean isInProgress() {
		return this.isInitialized && !this.isReady() && !this.isFinished();
	}
	
	/**
	 * Return true if the action is finished
	 * @return true if the action is finished, false if not
	 */
	public abstract boolean isFinished();
	
	/**
	 * Do a step for the action
	 * @throws ActionFinishedException The action is already finished
	 */
	public void doStep() throws ActionFinishedException {
		this.isReady = false;
	}
	
}

