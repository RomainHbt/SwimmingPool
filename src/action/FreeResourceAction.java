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
	public boolean isFinished() {
		return this.resourceful.getResource() == null;
	}
	
	@Override
	public void doStep() throws ActionFinishedException {
		super.doStep();
		R res = this.resourceful.getResource();
		this.pool.freeResource(res);
		this.resourceful.resetResource();
		System.out.println(this.resourceful.getSwimmer().getName() + " freeing resource from pool " + this.pool);
	}
}

