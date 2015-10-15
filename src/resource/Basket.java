package resource;


/**
 * Class to manage the Basket resources
 * 
 * @author dubois hembert
 *
 */
public class Basket implements Resource
{
	/**
	 * The constructor of a new Basket
	 */
	public Basket(){
		
	}

	/**
	 * @see Resource.description();
	 */
	public String description() {
		return "A basket";	
	}
}

