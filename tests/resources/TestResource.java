package resources;

import static org.junit.Assert.*;

import org.junit.Test;

import resource.Resource;

public abstract class TestResource {
	
	protected abstract Resource createResource();
	
	protected abstract String resultDescription();
	
	@Test
	public void testDescription() {
		Resource res = this.createResource();
		assertEquals(this.resultDescription(), res.description());
	}

}
