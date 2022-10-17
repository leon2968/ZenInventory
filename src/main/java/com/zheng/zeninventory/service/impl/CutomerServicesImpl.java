package com.zheng.zeninventory.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.zheng.zeninventory.model.Customer;
import com.zheng.zeninventory.repository.CustomerRepository;
import com.zheng.zeninventory.service.CustomerServices;

public class CutomerServicesImpl implements CustomerServices {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Customer> getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCustomer(long id, Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomer(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllCustomers() {
		// TODO Auto-generated method stub

	}

}
