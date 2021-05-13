package com.example.service;


import java.util.List;

import com.example.entities.OrderDetails;
import com.example.exceptions.IdNotFoundException;

public interface IOrderService {

	public OrderDetails addOrder(int cartId);
	public OrderDetails viewOrderById(int id) throws IdNotFoundException;
	public List<OrderDetails> viewAllOrdersByCustomer(int id);
	
	
}
