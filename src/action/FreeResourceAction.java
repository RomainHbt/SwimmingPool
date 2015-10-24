package action;

import pool.ResourcePool;
import resource.Resource;
import resource.ResourcefulUser;
import exceptions.ActionFinishedException;


/**
 * This class manage the free resource action, the dostep free the resource use by a swimmer
 * @author dubois hembert
 *
 * @param <R> The resource to free
 */

public class FreeResourceAction<R extends Resource> extends ResourceAction<R>
{
	/**
	 * The constructor of a new resource action
	 * @param pool The pool to add the resource
	 * @param resourceful the resource take by the swimmer earlier
	 */
	public FreeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> resourceful) {
		super(pool, resourceful);
	}
	
	/**
	 * @see Action#isFinished()
	 */
	@Override
	public boolean isFinished() {
		return this.resourceful.getResource() == null;
	}
	
	/**
	 * @see Action#doStep()
	 */
	@Override
	public void doStep() throws ActionFinishedException {
		super.doStep();
		R res = this.resourceful.getResource();
		this.pool.freeResource(res);
		this.resourceful.resetResource();
		System.out.println(this.resourceful.getSwimmer().getName() + " freeing resource from pool " + this.pool);
	}
}

