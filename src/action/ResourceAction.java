package action;

import exceptions.ActionFinishedException;
import pool.ResourcePool;
import resource.ResourcefulUser;

public class ResourceAction extends ForseeableAction {

	private ResourcePool<?> pool;
	private ResourcefulUser<?> resourceful;
	
	public ResourceAction(ResourcePool<?> pool, ResourcefulUser<?> resourceful) {
		super(1);
		this.resourceful = resourceful;
		this.pool = pool;
	}
	
	@Override
	public void doStep() throws ActionFinishedException{
		super.doStep();
	}

}
