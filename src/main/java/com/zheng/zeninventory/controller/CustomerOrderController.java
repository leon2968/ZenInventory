package com.zheng.zeninventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zheng.zeninventory.model.CustomerOrder;
import com.zheng.zeninventory.service.CustomerOrderServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerOrderController {

	@Autowired
	private CustomerOrderServices customerOrderServices;

	@GetMapping("/customerOrders")
	public List<CustomerOrder> getAllCustomerOrder(@RequestParam(required = false) String name) {
		return customerOrderServices.getAllCustomerOrders();

	}

	@GetMapping("/customerOrders/{id}")
	public Optional<CustomerOrder> getCustomerOrderById(@PathVariable("id") long id) {
		/*
		 * the TutorialRepository provides a method findById(). This methods takes the
		 * id of the Tutorial to find. This method used to be findOne(). But since
		 * Spring data jpa 2.0 it's changed to findById().
		 */
		return customerOrderServices.getCustomerOrderById(id);
	}
	/*
	 * To add new Tutorials is really easy. You do this by using the
	 * TutorialRepository save() method.
	 */
//   @PostMapping("/tutorials")
//   public void createTutorial(@RequestBody Tutorial tutorial) {
//       tutorialServices.addTutorial(tutorial);
//   }

	@PostMapping("/customerOrders")
	public void createCustomerOrder(@RequestBody CustomerOrder customerOrder) {
		customerOrderServices.createCustomerOrder(customerOrder);
	}

// To update a tutorial record, we used the same save() and findById()
	@PutMapping("/customerOrders/{id}")
   public void updateCustomerOrder(@PathVariable("id") long id, @RequestBody CustomerOrder customerOrder) {
       Optional<CustomerOrder> customerOrderData = customerOrderServices.getCustomerOrderById(id);

       if (customerOrderData.isPresent()) {
    	   CustomerOrder _customerOrder = customerOrderData.get();
           _customerOrder.setProduct(customerOrder.getProduct());
           _customerOrder.setPurchaseQuantity(customerOrder.getPurchaseQuantity());
           _customerOrder.setPurchasePrice(customerOrder.getPurchaseQuantity());
           customerOrderServices.createCustomerOrder(_customerOrder);
       }
   }

	// <input type="hidden" name="_method" value="delete"/>
	@DeleteMapping("/customerOrders/{id}")
	public void deleteCustomerOrder(@PathVariable("id") long id) {
		customerOrderServices.deleteCustomerOrder(id);
	}

	/*
	 * To delete a tutorials record, you simply use the deleteById() method provided
	 * by the tutorialRepository. Then you pass in the id of the record you want to
	 * delete.
	 */
	@DeleteMapping("/customerOrders")
	public void deleteAllCustomerOrders() {

		customerOrderServices.deleteAllCustomerOrders();
	}
//
//	@GetMapping("/tutorials/published")
//	public ResponseEntity<List<Tutorial>> findByPublished() {
//		return tutorialServices.findByPublished();
//	}
}
