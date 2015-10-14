package pool;


public class TestCubiclePool extends TestResourcePool {
	
	protected ResourcePool<?> createResourcePool() {
		return new CubiclePool(10);
	}
}
