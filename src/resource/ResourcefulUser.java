package resource;

import swimmer.Swimmer;


/**
 * Class to manage the resource use by a swimmer
 * @author dubois hembert
 *
 * @param <R> Type of the resource use in this helper
 */

public class ResourcefulUser<R extends Resource>
{
	
	protected R resource;
	protected Swimmer swimmer;
	
	/**
	 * Constructor of a new resource helper
	 * @param swimmer the swimmer using this the resource
	 */
	public ResourcefulUser(Swimmer swimmer){
		this.swimmer = swimmer;
	}

	/**
	 * Get the resource of this helper
	 * @return the resource of this helper
	 */
	public R getResource() {
		return this.resource;	
	}
	
	/**
	 * Set the resource of this helper
	 * @param resource the resource who change the resource of this helper
	 */
	public void setResource(R resource) {
		this.resource = resource;	
	}
	
	/**
	 * The resource of this helper become null
	 */
	public void resetResource() {
		this.resource = null;	
	}
	
	/**
	 * Get the swimmer of this helper
	 * @return the swimmer of this helper
	 */
	public Swimmer getSwimmer() {
		return this.swimmer;
	}
	
}

