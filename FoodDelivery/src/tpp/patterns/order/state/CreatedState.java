package tpp.patterns.order.state;

import tpp.patterns.order.Order;

public class CreatedState implements OrderState {

	@Override
	public void next(Order order) {
		order.setState(new PaidState());
	}

	@Override
	public void cancel(Order order) {
		order.setState(new CancelledState());
	}

	@Override
	public String name() {
		return "CREATED";
	}

}
