package tpp.patterns.order.state;

import tpp.patterns.order.Order;

public class CancelledState implements OrderState {
	
	@Override
	public void next(Order order) {
		throw new IllegalStateException("Order cancelled");
	}

	@Override
	public void cancel(Order order) {
	}

	@Override
	public String name() {
		return "CANCELLED";
	}
}