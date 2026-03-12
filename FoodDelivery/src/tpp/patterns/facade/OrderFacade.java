package tpp.patterns.facade;

import tpp.patterns.delivery.DeliveryService;
import tpp.patterns.order.Order;
import tpp.patterns.order.observer.AnalyticsService;
import tpp.patterns.order.observer.EmailNotification;
import tpp.patterns.order.observer.SMSNotification;
import tpp.patterns.payment.PaymentService;
import tpp.patterns.restaurant.dish.Dessert;
import tpp.patterns.restaurant.dish.MainDish;
import tpp.patterns.restaurant.factory.RestaurantFactory;

public class OrderFacade {
	private final PaymentService paymentService;
	private final DeliveryService deliveryService;
	private final RestaurantFactory restaurantFactory;

	public OrderFacade(PaymentService paymentService, DeliveryService deliveryService,
			RestaurantFactory restaurantFactory) {
		this.paymentService = paymentService;
		this.deliveryService = deliveryService;
		this.restaurantFactory = restaurantFactory;
	}

	public void placeOrder(Order order) {
		order.addObserver(new EmailNotification());
		order.addObserver(new SMSNotification());
		order.addObserver(new AnalyticsService());
		MainDish mainDish = restaurantFactory.createMainDish();
		Dessert dessert = restaurantFactory.createDessert();
		System.out.println("Preparing " + mainDish.name() + " with " + dessert.name());
		paymentService.process(order);
		order.next(); // -> paid
		order.next(); // -> preparing
		deliveryService.assignDriver(order);
		order.next(); // -> out for delivery
		order.next(); // -> delivered
	}
}
