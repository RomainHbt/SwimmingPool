package resource;


/**
 * 
 * Class who defined a Cubicle resource
 * @author dubois hembert
 *
 */
public class Cubicle implements Resource
{
	/**
	 * The constructor of a new cubicle
	 */
	public Cubicle(){
		super();
	}

	/**
	 * @see resource.Resource.description()
	 */
	public String description() {
		return "cubicle";	
	}
	
}

