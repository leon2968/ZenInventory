package com.zheng.zeninventory.controller.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zheng.zeninventory.model.CustomerOrder;
import com.zheng.zeninventory.service.CustomerOrderServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * REST API controller for customer orders
 */
@RestController
@RequestMapping("/api")
public class CustomerOrderRestController {

	@Autowired
	private CustomerOrderServices customerOrderServices;

	@GetMapping("/customerOrders")
	public List<CustomerOrder> getAllCustomerOrder(@RequestParam(required = false) String name) {
		return customerOrderServices.getAllCustomerOrders();

	}

	@GetMapping("/customerOrders/{id}")
	public Optional<CustomerOrder> getCustomerOrderById(@PathVariable("id") long id) {
		return customerOrderServices.getCustomerOrderById(id);
	}


	@PostMapping("/customerOrders")
	public void createCustomerOrder(@RequestBody CustomerOrder customerOrder) {
		customerOrderServices.createCustomerOrder(customerOrder);
	}

	@PutMapping("/customerOrders/{id}")
   public void updateCustomerOrder(@PathVariable("id") long id, @RequestBody CustomerOrder customerOrder) {
       customerOrderServices.updateCustomerOrder(id, customerOrder);
   }

	@DeleteMapping("/customerOrders/{id}")
	public void deleteCustomerOrder(@PathVariable("id") long id) {
		customerOrderServices.deleteCustomerOrder(id);
	}

	@DeleteMapping("/customerOrders")
	public void deleteAllCustomerOrders() {

		customerOrderServices.deleteAllCustomerOrders();
	}

}
