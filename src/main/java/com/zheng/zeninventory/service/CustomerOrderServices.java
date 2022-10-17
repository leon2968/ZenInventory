package com.zheng.zeninventory.service;

import java.util.List;
import java.util.Optional;

import com.zheng.zeninventory.model.CustomerOrder;

public interface CustomerOrderServices {


	public List<CustomerOrder> getAllCustomerOrders();

	public Optional<CustomerOrder> getCustomerOrderById(Long id);

	public void createCustomerOrder(CustomerOrder customerOrder);
	
	public void updateCustomerOrder(long id, CustomerOrder customerOrder);

	public void deleteCustomerOrder(long id);

	public void deleteAllCustomerOrders();

}

