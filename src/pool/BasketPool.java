package pool;
import resource.Basket;


/**
 * This class manage the pool of basket
 * 
 * @author dubois hembert
 *
 */

public class BasketPool extends ResourcePool<Basket>
{
	/**
	 * The constructor of a new BasketPool
	 * @param length the size of this pool
	 */
	public BasketPool(int length){
		super(length);
	}

	/**
	 * @see ResourcePool.newInstance()
	 */
	protected Basket newInstance() {
		return new Basket();	
	}
	
}

