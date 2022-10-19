package com.zheng.zeninventory.service.impl;

import com.zheng.zeninventory.model.CustomerOrder;
import com.zheng.zeninventory.repository.CustomerOrderRepository;
import com.zheng.zeninventory.service.CustomerOrderServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerOrderServicesImpl implements CustomerOrderServices{
	
	private static final Logger log = LoggerFactory.getLogger(CustomerOrderServicesImpl.class);
	
	@Autowired
	private CustomerOrderRepository customerOrderRepository;
	
	@Override
	public List<CustomerOrder> getAllCustomerOrders() {
		return customerOrderRepository.findAll();
	}
	
	@Override
	public Optional<CustomerOrder> getCustomerOrderById(Long id) {
		return customerOrderRepository.findById(id);
	}
	
	@Override
	public void createCustomerOrder(CustomerOrder customerOrder) {
		customerOrderRepository.save(customerOrder);
	}
	
	@Override
	public void updateCustomerOrder(long id, CustomerOrder customerOrder) {
		Optional<CustomerOrder> customerOrderData = customerOrderRepository.findById(id);

		if (customerOrderData.isPresent()) {
			CustomerOrder _customerOrder = customerOrderData.get();
			_customerOrder.setCustomer(customerOrder.getCustomer());
			_customerOrder.setProduct(customerOrder.getProduct());
			_customerOrder.setPurchaseQuantity(customerOrder.getPurchaseQuantity());
			_customerOrder.setPurchasePrice(customerOrder.getPurchasePrice());
			customerOrderRepository.save(_customerOrder);
		}
	}
	
	@Override
	public void deleteCustomerOrder(long id) {
		customerOrderRepository.deleteById(id);
	}
	
	@Override
	public void deleteAllCustomerOrders() {
		customerOrderRepository.deleteAll();
	}

//	to be implemented late
	
//	public ResponseEntity<List<CustomerOrder>> findByPublished() {
//		try {
//			List<Tutorial> tutorials = tutorialRepository.findByPublished(true);
//
//			if (tutorials.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			return new ResponseEntity<>(tutorials, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
}
