package resources;

import resource.Basket;
import resource.Resource;

public class TestBasket extends TestResource {

	@Override
	protected Resource createResource() {
		return new Basket();
	}

	@Override
	protected String resultDescription() {
		return "A basket";
	}

}
