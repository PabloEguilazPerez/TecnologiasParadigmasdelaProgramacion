package tpp.patterns.payment;

import tpp.patterns.order.Order;

public class PaypalPaymentService implements PaymentService {

	@Override
	public void process(Order order) {
		System.out.println("Processing PayPal payment for order " + order.getId());
	}
}