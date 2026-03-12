package tpp.patterns.delivery;

import java.util.HashMap;
import java.util.Map;

import tpp.patterns.order.Order;

public class DeliveryService {

	private Map<String, String> drivers;

	public DeliveryService() {
		drivers = new HashMap<>();

		drivers.put("D1", "Carlos");
		drivers.put("D2", "Maria");
		drivers.put("D3", "John");
	}

	public void assignDriver(Order order) {
		order.setDriver(drivers.get("D1"));

		System.out.println("Driver assigned for order " + order.getId());
	}
}