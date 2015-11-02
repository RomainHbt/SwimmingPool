package action;

import exceptions.ActionFinishedException;


/**
 * Class for sequential schedulers
 * @author dubois hembert
 */

public class SequentialScheduler extends Scheduler
{

	public SequentialScheduler(){
		super();
	}

	/**
	 * Do all step for each action, one action after another
	 */
	public void doStep() throws ActionFinishedException {
		super.doStep();
		Action toDo = this.actions.get(0);
		toDo.doStep();
		if(toDo.isFinished()){
			this.actions.remove(0);
		}
	}
	
}

