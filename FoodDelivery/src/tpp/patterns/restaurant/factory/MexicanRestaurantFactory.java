package tpp.patterns.restaurant.factory;

import tpp.patterns.restaurant.dish.Dessert;
import tpp.patterns.restaurant.dish.Flan;
import tpp.patterns.restaurant.dish.MainDish;
import tpp.patterns.restaurant.dish.Tacos;

public class MexicanRestaurantFactory implements RestaurantFactory {

	@Override
	public MainDish createMainDish() {
		return new Tacos();
	}

	@Override
	public Dessert createDessert() {
		return new Flan();
	}
}