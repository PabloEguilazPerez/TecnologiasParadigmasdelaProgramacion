package tpp.patterns.restaurant.factory;

import tpp.patterns.restaurant.dish.Dessert;
import tpp.patterns.restaurant.dish.MainDish;

public interface RestaurantFactory {
	MainDish createMainDish();

	Dessert createDessert();
}
