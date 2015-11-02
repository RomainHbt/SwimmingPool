package action;

import exceptions.ActionFinishedException;


public class SwimmerForseeableAction extends ForseeableAction {

	private String action;
	
	public SwimmerForseeableAction(int time, String action) {
		super(time);
		this.action = action;
	}
	
	public void doStep() throws ActionFinishedException{
		super.doStep();
		System.out.println(action);
	}

}
