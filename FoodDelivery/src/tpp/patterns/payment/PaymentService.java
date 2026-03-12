package tpp.patterns.payment;

import tpp.patterns.order.Order;

public interface PaymentService {
	void process(Order order);
}
