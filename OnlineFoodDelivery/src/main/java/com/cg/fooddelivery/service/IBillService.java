package com.cg.fooddelivery.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.fooddelivery.entities.Bill;
import com.cg.fooddelivery.entities.OrderDetails;



public interface IBillService {

	public Bill addBill(OrderDetails order);
	public String removeBill(Bill bill);
	public Bill viewBillById(int id);
	public List<Bill> viewBillsBetweenDates(LocalDate startDate,LocalDate endDate);
	public List<Bill>  viewBillsByCustomerId(int custId);
	public String calculateTotalCost(Bill bill);
} 

