package pool;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import resource.Resource;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public abstract class ResourcePool<R extends Resource>
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	protected List<R> resources;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	protected List<R> provideRes;
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	protected abstract R newInstance() ;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public R provideResource() {
		if(this.resources.size() == 0)
			throw new NoSuchElementException();
		
		R res = resources.remove(0);
		this.provideRes.add(res);
		
		return res;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void freeResource(R res) {
		if(!this.provideRes.contains(res))
			throw new IllegalArgumentException();
		
		provideRes.remove(res);
		this.resources.add(res);
	}
	
	public List<R> getResourceList() {
		return this.resources;
	}
	
	public List<R> getProvideResourceList() {
		return this.provideRes;
	}
	
}

