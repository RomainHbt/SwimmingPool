package pool;
import resource.Cubicle;


/**
 * Class to manage a cubicle pool
 * 
 * @author dubois hembert
 *
 */
public class CubiclePool extends ResourcePool<Cubicle>
{
	/**
	 * Constructor of a new CubiclePool
	 * @param length the size of this pool
	 */
	public CubiclePool(int length){
		super(length);
	}

	/**
	 * @see ResourcePool.newInstance()
	 */
	protected Cubicle newInstance() {
		return new Cubicle();	
	}
	
	public String toString() {
		return "cubicle";
	}
	
}

