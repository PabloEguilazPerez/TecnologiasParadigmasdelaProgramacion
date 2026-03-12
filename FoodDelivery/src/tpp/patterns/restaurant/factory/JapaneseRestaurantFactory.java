package tpp.patterns.restaurant.factory;

import tpp.patterns.restaurant.dish.Dessert;
import tpp.patterns.restaurant.dish.MainDish;
import tpp.patterns.restaurant.dish.Mochi;
import tpp.patterns.restaurant.dish.Sushi;

public class JapaneseRestaurantFactory implements RestaurantFactory {
	
	@Override
	public MainDish createMainDish() {
		return new Sushi();
	}

	@Override
	public Dessert createDessert() {
		return new Mochi();
	}
}