package resources;

import resource.Cubicle;
import resource.Resource;

public class TestCubicle extends TestResource {

	@Override
	protected Resource createResource() {
		return new Cubicle();
	}

	@Override
	protected String resultDescription() {
		return "A cubicle";
	}

}
