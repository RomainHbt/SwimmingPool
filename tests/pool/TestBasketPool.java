package pool;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import resource.Basket;


public class TestBasketPool extends TestResourcePool {
	
	protected ResourcePool<?> createResourcePool() {
		return new BasketPool(10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFreeResourceWhenResourceNotFromPool() {
		Basket res = new Basket();
		((BasketPool)this.pool).freeResource(res);
	}
	
	@Test
	public void testFreeResource() {
		Basket res = (Basket) this.pool.provideResource();
		((BasketPool)(this.pool)).freeResource(res);
		assertEquals(10, this.pool.getResourceList().size());
		assertEquals(0, this.pool.getProvideResourceList().size());
	}
}
