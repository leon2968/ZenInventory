package com.zheng.zeninventory.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zheng.zeninventory.model.Customer;
import com.zheng.zeninventory.repository.CustomerRepository;
import com.zheng.zeninventory.service.CustomerServices;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CutomerServicesImpl implements CustomerServices {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(Long id) {
		return customerRepository.findById(id);
	}

	@Override
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	@Override
	public void updateCustomer(long id, Customer customer) {
		Optional<Customer> customerData = customerRepository.findById(id);
		log.info("customerData in updateCustomer() method :" + customerData);
		log.trace("customerData in updateCustomer() method :" + customerData);
		if (customerData.isPresent()) {
			Customer _customer = customerData.get();
			_customer.setCustomerName(customer.getCustomerName());
			_customer.setCustomerAddress(customer.getCustomerAddress());
			_customer.setCustomerPhoneNo(customer.getCustomerPhoneNo());
			customerRepository.save(_customer);
		}
	}
	
	@Override
	public void deleteCustomer(long id) {
		System.out.println("detelte!");
		//customerRepository.deleteById(id);
	}
	
	@Override
	public void deleteAllCustomers() {
		customerRepository.deleteAll();
	}

}
