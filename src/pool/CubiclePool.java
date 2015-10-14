package pool;
import resource.Cubicle;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class CubiclePool extends ResourcePool<Cubicle>
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public CubiclePool(int length){
		super(length);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	protected Cubicle newInstance() {
		return new Cubicle();	
	}
	
}

