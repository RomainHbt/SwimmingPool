package action;

import exceptions.ActionFinishedException;

/**
 * Class for printing action for swimmers (dress, undress and swimming)
 * @author dubois hembert
 */

public class SwimmerForseeableAction extends ForseeableAction {

	private String action;
	
	public SwimmerForseeableAction(int time, String action) {
		super(time);
		this.action = action;
	}
	
	/**
	 * Print the action of swimmer
	 */
	public void doStep() throws ActionFinishedException{
		super.doStep();
		System.out.println(action);
	}

}
