package tpp.patterns.order.state;

import tpp.patterns.order.Order;

public interface OrderState {
	void next(Order order);

	void cancel(Order order);

	String name();
}