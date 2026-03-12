package tpp.patterns.order.state;

import tpp.patterns.order.Order;

public class PreparingState implements OrderState {

	@Override
	public void next(Order order) {
		order.setState(new OutForDeliveryState());
	}

	@Override
	public void cancel(Order order) {
		throw new IllegalStateException("Cannot cancel during preparation");
	}

	@Override
	public String name() {
		return "PREPARING";
	}
}