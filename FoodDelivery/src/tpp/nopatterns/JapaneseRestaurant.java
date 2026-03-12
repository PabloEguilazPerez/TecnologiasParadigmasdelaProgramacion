package tpp.nopatterns;

public class JapaneseRestaurant implements Restaurant {
	public void prepareFood(Order order) {
		System.out.println("Preparing sushi and mochi...");
	}
}
