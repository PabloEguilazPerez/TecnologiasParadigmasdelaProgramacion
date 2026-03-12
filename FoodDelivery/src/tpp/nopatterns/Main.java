package tpp.nopatterns;

public class Main {

	public static void main(String[] args) {
		OrderManager orderMngr = new OrderManager();
		Order order = new Order("ORD-1001", "user@server.com");

		orderMngr.placeOrder("ITALIAN", "CARD", order);

	}

}
