package com.zheng.zeninventory.service;

import java.util.List;
import java.util.Optional;

import com.zheng.zeninventory.model.CustomerOrder;

/*
 * Service interface for customer order
 */
public interface CustomerOrderServices {

	/*
	 * Method to return all customer orders
	 */
	public List<CustomerOrder> getAllCustomerOrders();
	
	/*
	 * Method to return a customer order by id
	 */
	public Optional<CustomerOrder> getCustomerOrderById(Long id);
	
	/*
	 * Method to create a new customer order
	 */
	public void createCustomerOrder(CustomerOrder customerOrder);
	
	/*
	 * Method to update customer order by id with new customer order info
	 */
	public void updateCustomerOrder(long id, CustomerOrder customerOrder);
	
	/*
	 * Method to delete a customer order
	 */
	public void deleteCustomerOrder(long id);
	
	/*
	 * Method to delete all customer orders
	 */
	public void deleteAllCustomerOrders();
	
	/*
	 * Method to return customer orders with missing customer and/or missing product
	 */
	public List<CustomerOrder> getAllCustomerOrdersWithMissingInfo();

}

