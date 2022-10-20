package com.zheng.zeninventory.service;

import java.util.List;
import java.util.Optional;

import com.zheng.zeninventory.model.Customer;

/*
 * Service interface for customer
 */
public interface CustomerServices {

	/*
	 * Method to return all customers
	 */
	public List<Customer> getAllCustomers();

	public Optional<Customer> getCustomerById(Long id);

	public void addCustomer(Customer customer);
	
	public void updateCustomer(long id, Customer customer);

	public void deleteCustomer(long id);

	public void deleteAllCustomers();

}