package com.zheng.zeninventory.controller.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zheng.zeninventory.model.Customer;
import com.zheng.zeninventory.model.Customer;
import com.zheng.zeninventory.service.CustomerServices;
import com.zheng.zeninventory.service.CustomerServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * REST API controller for customer
 */
@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerServices customerServices;

	@GetMapping("/customers")
	public List<Customer> getAllCustomer(@RequestParam(required = false) String name) {
		return customerServices.getAllCustomers();

	}

	@GetMapping("/customers/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") long id) {

		return customerServices.getCustomerById(id);
	}

	@PostMapping("/customers")
	public void createCustomer(@RequestBody Customer customer) {
		customerServices.addCustomer(customer);
	}

	@PutMapping("/customers/{id}")
	public void updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		customerServices.updateCustomer(id, customer);
	}

	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable("id") long id) {
		customerServices.deleteCustomer(id);
	}

	@DeleteMapping("/customers")
	public void deleteAllCustomers() {

		customerServices.deleteAllCustomers();
	}

}
