package action;

import pool.ResourcePool;
import resource.Resource;
import resource.ResourcefulUser;
import exceptions.ActionFinishedException;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class FreeResourceAction<R extends Resource> extends ResourceAction<R>
{
	public FreeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> resourceful) {
		super(pool, resourceful);
	}
	
	@Override
	public void doStep() throws ActionFinishedException {
		R res = this.resourceful.getResource();
		this.pool.freeResource(res);
		this.resourceful.resetResource();
		
		super.doStep();
	}
}

