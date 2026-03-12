package tpp.patterns;

import tpp.patterns.payment.CardPaymentService;
import tpp.patterns.payment.PaymentService;
import tpp.patterns.restaurant.factory.ItalianRestaurantFactory;
import tpp.patterns.restaurant.factory.RestaurantFactory;
import tpp.patterns.delivery.DeliveryService;
import tpp.patterns.facade.OrderFacade;
import tpp.patterns.order.Order;

public class Main {

	public static void main(String[] args) {
		PaymentService payment = new CardPaymentService();
		DeliveryService delivery = new DeliveryService();
		RestaurantFactory factory = new ItalianRestaurantFactory();
		OrderFacade facade = new OrderFacade(payment, delivery, factory);
		Order order = new Order("ORD-1001", "user@server.com");
		facade.placeOrder(order);
		System.out.println("Final State: " + order.getStatus());

	}

}
