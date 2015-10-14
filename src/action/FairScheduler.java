package action;

import exceptions.ActionFinishedException;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class FairScheduler extends Scheduler
{
	
	private int index;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public FairScheduler(){
		super();
		this.index = 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @throws ActionFinishedException 
	 * @generated
	 * @ordered
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

