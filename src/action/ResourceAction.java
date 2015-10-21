package action;

import exceptions.ActionFinishedException;
import pool.ResourcePool;
import resource.Resource;
import resource.ResourcefulUser;

public class ResourceAction<R extends Resource> extends Action {

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

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
