package action;

import exceptions.ActionFinishedException;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class SequentialScheduler extends Scheduler
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public SequentialScheduler(){
		super();
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
		Action toDo = this.actions.get(0);
		toDo.doStep();
		if(toDo.isFinished()){
			this.actions.remove(0);
		}
	}
	
}

