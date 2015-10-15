package pool;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import resource.Cubicle;


public class TestCubiclePool extends TestResourcePool {
	
	protected ResourcePool<?> createResourcePool() {
		return new CubiclePool(10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFreeResourceWhenResourceNotFromPool() {
		Cubicle res = new Cubicle();
		((CubiclePool)this.pool).freeResource(res);
	}
	
	@Test
	public void testFreeResource() {
		Cubicle res = (Cubicle) this.pool.provideResource();
		((CubiclePool)(this.pool)).freeResource(res);
		assertEquals(10, this.pool.getResourceList().size());
		assertEquals(0, this.pool.getProvideResourceList().size());
	}
}
