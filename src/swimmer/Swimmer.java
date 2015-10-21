package swimmer;
import pool.BasketPool;
import pool.CubiclePool;
import resource.Basket;
import resource.Cubicle;
import resource.ResourcefulUser;
import action.FreeResourceAction;
import action.SequentialScheduler;
import action.TakeResourceAction;


/**
 * Class to manage the swimmers
 * @author dubois hembert
 *
 */
public class Swimmer extends SequentialScheduler
{
	
	private String name;
	private BasketPool basketAdministrator;
	private CubiclePool cubicleAdministrator;
	private int undressTime;
	private int bathTime;
	private int dressTime;
	
	private ResourcefulUser<Basket> basket;
	private ResourcefulUser<Cubicle> cubicle;
	
	/**
	 * Constructor of a new swimmer
	 * @param name the name of this swimmer
	 * @param bA the basket pool of this swimmer
	 * @param cA the cubicle pool of this swimmer
	 * @param undressTime the undress time of this swimmer
	 * @param bathTime the bath time of this swimmer
	 * @param dressTime the dress time of this swimmer
	 */
	public Swimmer(String name, BasketPool bA, CubiclePool cA, int undressTime, int bathTime, int dressTime) {
		super();
		this.name = name;
		this.basketAdministrator = bA;
		this.cubicleAdministrator = cA;
		this.undressTime = undressTime;
		this.bathTime = bathTime;
		this.dressTime = dressTime;
		
		this.basket = new ResourcefulUser<>();
		this.cubicle = new ResourcefulUser<>();
		
		this.addAction(new TakeResourceAction(this.basketAdministrator, this.basket));
		this.addAction(new TakeResourceAction(this.cubicleAdministrator, this.cubicle));
		// Temps deshabillage
		this.addAction(new FreeResourceAction(this.cubicleAdministrator, this.cubicle));
		
		this.addAction(new TakeResourceAction(this.cubicleAdministrator, this.cubicle));
		
		this.addAction(new FreeResourceAction(this.cubicleAdministrator, this.cubicle));
		
	}
	
	/**
	 * Get the name of this swimmer
	 * @return the name of this swimmer
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the basket pool of this swimmer
	 * @return the basket pool of this swimmer
	 */
	public BasketPool getBasketAdministrator() {
		return this.basketAdministrator;
	}
	
	/**
	 * Get the cubicle pool of this swimmer
	 * @return the cubicle pool of this swimmer
	 */
	public CubiclePool getCubicleAdministrator() {
		return this.cubicleAdministrator;
	}
	
	/**
	 * Get the undress time of this swimmer
	 * @return the undress time of this swimmer
	 */
	public int getUndressTime() {
		return this.undressTime;
	}
	
	/**
	 * Get the bath time of this swimmer
	 * @return the bath time of this swimmer
	 */
	public int getBathTime() {
		return this.bathTime;
	}
	
	/**
	 * Get the dress time of this swimmer
	 * @return the dress time of this swimmer
	 */
	public int getDressTime() {
		return this.dressTime;
	}
	
}

