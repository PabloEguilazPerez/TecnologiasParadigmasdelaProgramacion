package tpp.patterns.payment;

import tpp.patterns.order.Order;

public class CashPaymentService implements PaymentService {

	@Override
	public void process(Order order) {
		System.out.println("Processing cash payment for order " + order.getId());
	}
}