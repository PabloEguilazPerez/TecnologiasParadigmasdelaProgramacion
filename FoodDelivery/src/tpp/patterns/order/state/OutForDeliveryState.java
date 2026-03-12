package tpp.patterns.order.state;

import tpp.patterns.order.Order;

public class OutForDeliveryState implements OrderState {

	@Override
	public void next(Order order) {
		order.setState(new DeliveredState());
	}

	@Override
	public void cancel(Order order) {
		throw new IllegalStateException("Cannot cancel when out for delivery");
	}

	@Override
	public String name() {
		return "OUT_FOR_DELIVERY";
	}
}