package tpp.patterns.order.observer;

import tpp.patterns.order.Order;

public class AnalyticsService implements OrderObserver {
	public void update(Order order) {
		System.out.println("[Analytics] Recorded state: " + order.getStatus());
	}
}