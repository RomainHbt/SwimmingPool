package action;

import exceptions.ActionFinishedException;


/**
 * Class for fair schedulers
 * @author dubois hembert
 */

public class FairScheduler extends Scheduler
{
	
	private int index;
	
	public FairScheduler(){
		super();
		this.index = 0;
	}

	/**
	 * Do a step for each action, one after another
	 */
	public void doStep() throws ActionFinishedException {
		super.doStep();
		Action toDo = this.actions.get(index);
		toDo.doStep();
		if(toDo.isFinished()){
			this.actions.remove(index);
		}
		
		try {
			if(this.actions.get(index+1) != null){
				index++;
			}
		} catch (IndexOutOfBoundsException e) {
			index = 0;
		}
	}
	
}

