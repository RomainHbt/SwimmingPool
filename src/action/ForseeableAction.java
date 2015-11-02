package action;

import exceptions.ActionFinishedException;


/**
 * Class for action which need a remaining time
 * @author dubois hembert
 */

public class ForseeableAction extends Action
{
	
	private int remainingTime;
	private int totalTime;
	
	public ForseeableAction(int timeToEnd){
		super();
		this.totalTime = timeToEnd;
		this.remainingTime = timeToEnd;
	}
	
	public int getRemainingTime() {
		return remainingTime;
	}

	public int getTotalTime() {
		return totalTime;
	}

	/**
	 * Do a step for the action
	 */
	public void doStep() throws ActionFinishedException{
		super.doStep();
		if(this.remainingTime == 0)
			throw new ActionFinishedException();
		this.remainingTime--;
	}
	
	public boolean isFinished(){
		return this.remainingTime == 0;
	}

}

