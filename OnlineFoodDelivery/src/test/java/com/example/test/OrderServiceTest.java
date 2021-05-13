package com.example.test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.entities.Address;
import com.example.entities.Customer;
import com.example.entities.OrderDetails;
import com.example.entities.Restaurant;
import com.example.repository.IOrderRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class OrderServiceTest {

	@Autowired
	IOrderRepository repository;

	@Test
	void testViewAllOrdersByRestaurant() {
		List<OrderDetails> list=repository.findAllByRestaurant("Annapurna");
		assertNotNull(list);

	}

	public Customer getCustomer()
	{
		Customer cust=new Customer();
		cust.setAddress(getAddress());
		cust.setAge(22);
		cust.setCustomerId(1);
		cust.setEmail("Amit@gmail.com");
		cust.setFirstName("Amit");
		cust.setGender("M");
		cust.setLastName("Shinde");
		cust.setMobileNumber("987456242");
		return cust;
	}
	public Address getAddress()
	{
		Address add=new Address();
		add.setAddressId(2);
		add.setArea("Hadapsar");
		add.setBuildingName("Pebble");
		add.setCity("Pune");
		add.setCountry("India");
		add.setPincode("41160");
		add.setState("Maharashtra");
		add.setStreetNo("93");
		return add;
	}
	public Restaurant getRestaurant()
	{
		Restaurant res=new Restaurant();
		res.setAddress(getAddress());
		res.setContactNumber("9866042006");
	    res.setManagerName("ravi");
	    res.setRestaurantId(4);
	    res.setRestaurantName("Annapurna");
	    return res;
	}
	public OrderDetails getOrder()
	{
		OrderDetails ord=new OrderDetails();
		ord.setCustomer(getCustomer());
		ord.setList(null);
		ord.setOrderDate(LocalDateTime.now());
		ord.setOrderId(11);
		ord.setOrderStatus("delivered");
		ord.setRestaurant(getRestaurant());
		return ord;
	}
}
