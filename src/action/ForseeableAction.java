package action;

import exceptions.ActionFinishedException;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class ForseeableAction extends Action
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int remainingTime;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int totalTime;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
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

