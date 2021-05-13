package com.cg.fooddelivery.service;


import java.util.List;

import com.cg.fooddelivery.entities.OrderDetails;
import com.cg.fooddelivery.exceptions.IdNotFoundException;

public interface IOrderService {

	public OrderDetails addOrder(int cartId);
	public OrderDetails viewOrderById(int id) throws IdNotFoundException;
	public List<OrderDetails> viewAllOrdersByCustomer(int id);
	
	
}
