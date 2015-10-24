package action;

import pool.ResourcePool;
import resource.Resource;
import resource.ResourcefulUser;

/**
 * Abstract class to manage the actions based on resources
 * @author dubois hembert
 *
 * @param <R> The resources to manage the action
 */
public abstract class ResourceAction<R extends Resource> extends Action {

	protected ResourcePool<R> pool;
	protected ResourcefulUser<R> resourceful;
	
	/**
	 * Constructor of a new Resource action
	 * @param pool the pool to manage the resource
	 * @param resourceful the user resource helper
	 */
	public ResourceAction(ResourcePool<R> pool, ResourcefulUser<R> resourceful) {
		super();
		this.resourceful = resourceful;
		this.pool = pool;
	}

}
