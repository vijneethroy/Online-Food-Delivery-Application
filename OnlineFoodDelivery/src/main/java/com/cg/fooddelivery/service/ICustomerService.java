package com.cg.fooddelivery.service;

import java.util.List;

import com.cg.fooddelivery.entities.Customer;



public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer viewCustomerById(int id ) ;
	public List<Customer> viewAllCustomer(String restaurantname);
	public String removeCustomerById(int id)  ;
	 
}