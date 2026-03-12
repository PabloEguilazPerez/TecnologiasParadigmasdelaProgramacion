package tpp.patterns.order.observer;

import tpp.patterns.order.Order;

public class EmailNotification implements OrderObserver {
	public void update(Order order) {
		System.out.println("[Email] Order " + order.getId() + " changed to " + order.getStatus());
	}
}