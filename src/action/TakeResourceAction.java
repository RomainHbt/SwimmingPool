package action;

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
	public void doStep() throws ActionFinishedException{
		// TODO : A corriger !
		R r = this.pool.provideResource();
		if(r != null){
			this.resourceful.setResource(r);
			super.doStep();
		}
	}

}

