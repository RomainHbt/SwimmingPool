package pool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import resource.Resource;

public abstract class TestResourcePool {
	
	protected ResourcePool<?> pool;
	
	@Before
	public void init() {
		this.pool = this.createResourcePool();
	}
	
	protected ResourcePool<?> createResourcePool() {
		return new MockResourcePool(10);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testProvideResourceWhenResourceNotAvailable() {
		this.pool.provideResource();
		this.pool.provideResource();
		this.pool.provideResource();
		this.pool.provideResource();
		this.pool.provideResource();
		this.pool.provideResource();
		this.pool.provideResource();
		this.pool.provideResource();
		this.pool.provideResource();
		this.pool.provideResource();
		this.pool.provideResource();
	}
	
	@Test
	public void testProvideResource() {
		assertEquals(10, this.pool.getResourceList().size());
		assertEquals(0, this.pool.getProvideResourceList().size());
		
		this.pool.provideResource();
		assertEquals(9, this.pool.getResourceList().size());
		assertEquals(1, this.pool.getProvideResourceList().size());
		
		this.pool.provideResource();
		assertEquals(8, this.pool.getResourceList().size());
		assertEquals(2, this.pool.getProvideResourceList().size());
	}

	
	// mock classes for tests
	private class MockResource implements Resource {
		
		@Override
		public String description() {			
			return "1";
		}
		
	}
	
	private class MockResourcePool extends ResourcePool<MockResource> {

		public MockResourcePool(int length) {
			super(length);
		}

		@Override
		protected MockResource newInstance() {
			return new MockResource();
		}
	
	}
	
	
	
	
}
