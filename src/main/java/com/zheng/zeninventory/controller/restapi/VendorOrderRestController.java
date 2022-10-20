package com.zheng.zeninventory.controller.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zheng.zeninventory.model.VendorOrder;
import com.zheng.zeninventory.model.VendorOrder;
import com.zheng.zeninventory.service.VendorOrderServices;
import com.zheng.zeninventory.service.VendorOrderServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * REST API controller for vendor orders
 */
@RestController
@RequestMapping("/api")
public class VendorOrderRestController {

	@Autowired
	private VendorOrderServices vendorOrderServices;

	@GetMapping("/vendorOrders")
	public List<VendorOrder> getAllVendorOrder(@RequestParam(required = false) String name) {
		return vendorOrderServices.getAllVendorOrders();

	}

	@GetMapping("/vendorOrders/{id}")
	public Optional<VendorOrder> getVendorOrderById(@PathVariable("id") long id) {

		return vendorOrderServices.getVendorOrderById(id);
	}

	@PostMapping("/vendorOrders")
	public void createVendorOrder(@RequestBody VendorOrder vendorOrder) {
		vendorOrderServices.createVendorOrder(vendorOrder);
	}

	@PutMapping("/vendorOrders/{id}")
	public void updateVendorOrder(@PathVariable("id") long id, @RequestBody VendorOrder vendorOrder) {
		vendorOrderServices.updateVendorOrder(id, vendorOrder);
	}

	@DeleteMapping("/vendorOrders/{id}")
	public void deleteVendorOrder(@PathVariable("id") long id) {
		vendorOrderServices.deleteVendorOrder(id);
	}

	@DeleteMapping("/vendorOrders")
	public void deleteAllVendorOrders() {

		vendorOrderServices.deleteAllVendorOrders();
	}

}
