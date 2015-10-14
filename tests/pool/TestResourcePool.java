package pool;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import resource.Resource;

import static org.junit.Assert.*;

public abstract class TestResourcePool {
	
	private ResourcePool<?> pool;
	
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
		
		Resource res = this.pool.provideResource();
		assertTrue(res instanceof MockResource);
		assertEquals(9, this.pool.getResourceList().size());
		assertEquals(1, this.pool.getProvideResourceList().size());
		
		res = this.pool.provideResource();
		assertTrue(res instanceof MockResource);
		assertEquals(8, this.pool.getResourceList().size());
		assertEquals(2, this.pool.getProvideResourceList().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFreeResourceWhenResourceNotFromPool() {
		Resource res = new MockResourceFailure();
		this.pool.provideResource();
		this.pool.freeResource(res);
	}
	
	@Test
	public void testFreeResource() {
		Resource res = this.pool.provideResource();
		this.pool.freeResource(res);
		assertEquals(10, this.pool.getResourceList().size());
		assertEquals(0, this.pool.getProvideResourceList().size());
	}

	
	// mock classes for tests
	private class MockResource implements Resource {
		
		@Override
		public String description() {			
			return "1";
		}
		
	}
	
	private class MockResourceFailure implements Resource {

		@Override
		public String description() {
			return null;
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
