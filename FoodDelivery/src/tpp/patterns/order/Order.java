package tpp.patterns.order;

import java.util.ArrayList;
import java.util.List;

import tpp.patterns.order.observer.OrderObserver;
import tpp.patterns.order.state.CreatedState;
import tpp.patterns.order.state.OrderState;

public class Order {
	private String id;
	private OrderState state;
	private List<OrderObserver> observers = new ArrayList<OrderObserver>();
	private String driver;
	private String customerEmail;

	public Order(String id, String email) {
		this.id = id;
		this.state = new CreatedState();
		this.customerEmail = email;
	}

	public void next() {
		state.next(this);
		notifyObservers();
	}

	public void cancel() {
		state.cancel(this);
		notifyObservers();
	}

	public void addObserver(OrderObserver observer) {
		observers.add(observer);
	}

	private void notifyObservers() {
		for (OrderObserver observer : observers) {
			observer.update(this);
		}
	}

	public String getId() {
		return id;
	}

	public String getStatus() {
		return state.name();
	}

	public void setState(OrderState state) {
		this.state = state;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}
}