package action;

import exceptions.ActionFinishedException;
import pool.ResourcePool;
import resource.Resource;
import resource.ResourcefulUser;

public abstract class ResourceAction<R extends Resource> extends Action {

	protected ResourcePool<R> pool;
	protected ResourcefulUser<R> resourceful;
	
	public ResourceAction(ResourcePool<R> pool, ResourcefulUser<R> resourceful) {
		super();
		this.resourceful = resourceful;
		this.pool = pool;
	}
	
	@Override
	public void doStep() throws ActionFinishedException{
		super.doStep();
	}

}
