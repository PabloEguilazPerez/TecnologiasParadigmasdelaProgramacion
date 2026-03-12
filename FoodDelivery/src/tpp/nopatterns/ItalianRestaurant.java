package tpp.nopatterns;

public class ItalianRestaurant implements Restaurant {
	public void prepareFood(Order order) {
		System.out.println("Preparing pizza and tiramisu...");
	}
}
