package tpp.patterns.restaurant.factory;

import tpp.patterns.restaurant.dish.Dessert;
import tpp.patterns.restaurant.dish.MainDish;
import tpp.patterns.restaurant.dish.Pizza;
import tpp.patterns.restaurant.dish.Tiramisu;

public class ItalianRestaurantFactory implements RestaurantFactory {
	
	@Override
	public MainDish createMainDish() {
		return new Pizza();
	}

	@Override
	public Dessert createDessert() {
		return new Tiramisu();
	}
}