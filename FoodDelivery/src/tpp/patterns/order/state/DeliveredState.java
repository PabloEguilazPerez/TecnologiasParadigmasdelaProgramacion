package tpp.patterns.order.state;

import tpp.patterns.order.Order;

public class DeliveredState implements OrderState {

	@Override
	public void next(Order order) {
		throw new IllegalStateException("Order already delivered");
	}

	@Override
	public void cancel(Order order) {
		throw new IllegalStateException("Cannot cancel delivered order");
	}

	@Override
	public String name() {
		return "DELIVERED";
	}
}