package com.example.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.FoodCart;
import com.example.entities.Item;
import com.example.entities.OrderDetails;
import com.example.entities.Restaurant;
import com.example.exceptions.IdNotFoundException;
import com.example.repository.ICartRepository;
import com.example.repository.IItemRepository;
import com.example.repository.IOrderRepository;



@Service
@Transactional
public class OrderService implements IOrderService{
	
	@Autowired
	IOrderRepository repository;
	
	@Autowired
	ICartRepository repo2;
	
	@Autowired
	IItemRepository repo3;	
	
	@Autowired
	CartServiceImpl service;
	
	

	@Override
	public OrderDetails addOrder(int cartId) {
		
		OrderDetails order=new OrderDetails();
		FoodCart cart=repo2.findById(cartId).orElse(null);
		List<Item> orderList=new ArrayList<Item>();
		
		List<Item> item1=cart.getItemList();
		int list_size=item1.size();
		for(int i=0;i<list_size;i++)
		{
			Item item=item1.get(i);
			orderList.add(item);
		}
		Restaurant rest=item1.get(0).getRestaurant();
		order.setCustomer(cart.getCustomer());
		order.setRestaurant(rest);
		order.setList(orderList);
		order.setOrderDate(LocalDateTime.now());
		order.setOrderStatus("Pending");
		repository.save(order);
		service.clearCart(cartId);		
		return order;
	}

	@Override
	public OrderDetails viewOrderById(int id) throws IdNotFoundException {
		
		OrderDetails order=repository.findById(id).orElse(null);
		if (order == null) {
			throw new IdNotFoundException("id not found");
		}
		System.out.println("View list in order :"+order.getList());
		order.setList(order.getList());
		return order;
	}
	
	@Override
	public List<OrderDetails> viewAllOrdersByCustomer(int id) {
	
		List<OrderDetails> list = repository.findAllOrdersByCustomer(id);
		System.out.println(list);
		return list;
	}


	
}

	
	
