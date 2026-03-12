package tpp.nopatterns;

public class MexicanRestaurant implements Restaurant {
	public void prepareFood(Order order) {
		System.out.println("Preparing tacos and flan...");
	}
}