package tpp.nopatterns;

import java.util.*;

public class OrderManager {
	private List<Order> orders = new ArrayList<>();
	private Map<String, String> drivers = new HashMap<>();

	public OrderManager() {
		drivers.put("D1", "Carlos");
		drivers.put("D2", "Maria");
		drivers.put("D3", "John");
	}

	public void placeOrder(String restaurantType, String paymentType, Order order) {
		System.out.println("Placing order...");
		Restaurant restaurant;
		if (restaurantType.equals("ITALIAN")) {
			restaurant = new ItalianRestaurant();
		} else if (restaurantType.equals("JAPANESE")) {
			restaurant = new JapaneseRestaurant();
		} else if (restaurantType.equals("MEXICAN")) {
			restaurant = new MexicanRestaurant();
		} else {
			throw new IllegalArgumentException("Unknown restaurant type");
		}
		restaurant.prepareFood(order);
		if (paymentType.equals("CARD")) {
			processCard(order);
		} else if (paymentType.equals("PAYPAL")) {
			processPaypal(order);
		} else if (paymentType.equals("CASH")) {
			processCash(order);
		}
		updateState(order); // -> PAID
		updateState(order); // -> PREPARING
		assignDriver(order);
		updateState(order); // -> OUT_FOR_DELIVERY
		updateState(order); // -> DELIVERED
		sendEmail(order);
		orders.add(order);
	}

	private void processCard(Order order) {
		System.out.println("Processing card payment...");
		order.setPaid(true);
	}

	private void processPaypal(Order order) {
		System.out.println("Processing PayPal payment...");
		order.setPaid(true);
	}

	private void processCash(Order order) {
		System.out.println("Cash on delivery selected...");
	}

	private void updateState(Order order) {
		switch (order.getStatus()) {
		case "CREATED":
			order.setStatus("PAID");
			System.out.println("Status changed to PAID");
			break;
		case "PAID":
			order.setStatus("PREPARING");
			System.out.println("Status changed to PREPARING");
			break;
		case "PREPARING":
			order.setStatus("OUT_FOR_DELIVERY");
			System.out.println("Status changed to OUT_FOR_DELIVERY");
			break;
		case "OUT_FOR_DELIVERY":
			order.setStatus("DELIVERED");
			System.out.println("Status changed to DELIVERED");
			break;
		}
	}

	private void assignDriver(Order order) {
		order.setDriver(drivers.get("D1"));
		System.out.println("Driver assigned.");
	}

	private void sendEmail(Order order) {
		System.out.println("Sending email to " + order.getCustomerEmail());
	}
}