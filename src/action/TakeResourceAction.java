package action;

import java.util.NoSuchElementException;

import exceptions.ActionFinishedException;
import pool.ResourcePool;
import resource.Resource;
import resource.ResourcefulUser;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class TakeResourceAction<R extends Resource> extends ResourceAction<R> {
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public TakeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> resourceful){
		super(pool, resourceful);
	}
	
	@Override
	public boolean isFinished() {
		return this.resourceful.getResource() != null;
	}
	
	@Override
	public void doStep() throws ActionFinishedException{
		super.doStep();
		String result = "";
		try {
			R r = this.pool.provideResource();
			this.resourceful.setResource(r);
			result = "success";
		} catch(NoSuchElementException e) {
			result = "failed";
		}
		System.out.println(this.resourceful.getSwimmer().getName() + " trying to take resource from pool " + this.pool + "... " + result);
	}

}

