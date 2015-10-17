package swimmer;
import pool.BasketPool;
import pool.CubiclePool;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Swimmer
{
	
	private String name;
	private BasketPool basketAdministrator;
	private CubiclePool cubicleAdministrator;
	private int undressTime;
	private int bathTime;
	private int dressTime;
	
	public Swimmer(String name, BasketPool bA, CubiclePool cA, int undressTime, int bathTime, int dressTime) {
		this.name = name;
		this.basketAdministrator = bA;
		this.cubicleAdministrator = cA;
		this.undressTime = undressTime;
		this.bathTime = bathTime;
		this.dressTime = dressTime;
	}
	
}

