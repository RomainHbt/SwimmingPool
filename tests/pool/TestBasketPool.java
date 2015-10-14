package pool;


public class TestBasketPool extends TestResourcePool {
	
	protected ResourcePool<?> createResourcePool() {
		return new BasketPool(10);
	}
}
