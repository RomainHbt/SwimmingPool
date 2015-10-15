package pool;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import resource.Resource;



/**
 * This class manage a pool of resource of type R
 * 
 * @author dubois hembert
 *
 * @param <R> The type of the object extends of resource to use
 */

public abstract class ResourcePool<R extends Resource>
{
	/**
	 * The list of the resource available
	 */
	protected List<R> resources;
	
	/**
	 * The list of the resource not available
	 */
	protected List<R> provideRes;
	

	/**
	 * The constructor of a ResourcePool
	 * @param length The size capacity of this resource pool
	 */
	public ResourcePool(int length) {
		super();
		this.resources = new LinkedList<R>();
		this.provideRes = new LinkedList<R>();
		for(int i = 0; i < length; i++) {
			this.resources.add(this.newInstance());
		}
	}
	
	/**
	 * Factory method to create an instance of a new object extends of Resource
	 * @return A new instace of an object extends of Resource
	 */
	protected abstract R newInstance() ;
	
	/**
	 * Take one resource of this resource pool and passed this resource in status not available
	 * @return The resource taken
	 * @exception NoSuchElementException if the list of the resource available is empty
	 */
	public R provideResource() {
		if(this.resources.size() == 0)
			throw new NoSuchElementException();
		
		R res = resources.remove(0);
		this.provideRes.add(res);
		
		return res;	
	}
	
	/**
	 * Return a resource on the list of resource available and remove this resource on the list of resources not available
	 * @param res The resource to return
	 * @exception IllegalArgumentException if the resource is not valid
	 */
	public void freeResource(R res) {
		if(!this.provideRes.contains(res))
			throw new IllegalArgumentException();
		
		provideRes.remove(res);
		this.resources.add(res);
	}
	
	/**
	 * Get the list of the resources available
	 * @return the list of the resources available
	 */
	public List<R> getResourceList() {
		return this.resources;
	}
	
	/**
	 * Get the list of the resources not available
	 * @return the list of the resources not available
	 */
	public List<R> getProvideResourceList() {
		return this.provideRes;
	}
	
}

