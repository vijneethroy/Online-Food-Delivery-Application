package com.cg.fooddelivery.ctrl;

import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fooddelivery.entities.OrderDetails;
import com.cg.fooddelivery.exceptions.IdNotFoundException;
import com.cg.fooddelivery.service.ICartService;
import com.cg.fooddelivery.service.IOrderService;


@RestController
public class OrderController {
	
	@Autowired
	IOrderService orderservice;
	
	@Autowired
	ICartService cartService;
	
	Logger logger=LoggerFactory.getLogger(OrderController.class);

	@PostMapping("/addOrder/{cartId}")
	public ResponseEntity<OrderDetails> addOrder(@PathVariable("cartId") int cartId)
	{
		logger.info("Inside add order method");
		OrderDetails order2 =orderservice.addOrder(cartId);
	   	return new ResponseEntity<OrderDetails>(order2,HttpStatus.OK);
	}
	
	@GetMapping("/viewOrderByOrderId/{orderId}")
	public ResponseEntity<OrderDetails> viewOrder(@PathVariable("orderId") int oid) throws IdNotFoundException 
	{
		logger.info("Inside view order by Id method");
		OrderDetails order2 = orderservice.viewOrderById(oid);
		if(order2==null)
		{
			throw new IdNotFoundException("Order id not found !!!");
		}
		else
		{
			return new ResponseEntity<OrderDetails>(order2, HttpStatus.OK);
		}
	
	}
	
	
	@GetMapping("/viewAllOrdersByCustomer/{customerId}")
	public ResponseEntity<List<OrderDetails>> viewAllOrdersByCustomer(@PathVariable("customerId") int id) throws IdNotFoundException 
	{
		logger.info("Inside view all order by customer Id method");
		List<OrderDetails> order2 = orderservice.viewAllOrdersByCustomer(id);
		if(order2.isEmpty())
		{
			throw new IdNotFoundException("Invalid customer !!!");
		}
		else
		{
			return new ResponseEntity<List<OrderDetails>>(order2, HttpStatus.OK);
		}
	}
	
	
}
