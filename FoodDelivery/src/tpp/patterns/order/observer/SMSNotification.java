package tpp.patterns.order.observer;

import tpp.patterns.order.Order;

public class SMSNotification implements OrderObserver {
	public void update(Order order) {
		System.out.println("[SMS] Order " + order.getId() + " changed to " + order.getStatus());
	}
}