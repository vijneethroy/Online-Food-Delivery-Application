package com.cg.fooddelivery.service;

import java.util.List;

import com.cg.fooddelivery.entities.Restaurant;


public interface IRestaurantService {

	public Restaurant addRestaurant(Restaurant res);
	public Restaurant updateRestaurant(Restaurant res);
	public String removeRestaurantById(int id);
	public Restaurant viewRestaurantById(int id);
	public List<Restaurant> viewAllRestaurants();
	public List<Restaurant> viewNearByRestaurant(String location);
	public List<Restaurant> viewRestaurantByItemName(String name);

}
