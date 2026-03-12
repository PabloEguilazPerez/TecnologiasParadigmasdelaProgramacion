package tpp.patterns.order.observer;

import tpp.patterns.order.Order;

public interface OrderObserver {
	void update(Order order);
}
