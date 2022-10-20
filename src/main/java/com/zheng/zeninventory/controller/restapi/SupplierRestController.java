package com.zheng.zeninventory.controller.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zheng.zeninventory.model.Supplier;
import com.zheng.zeninventory.model.Supplier;
import com.zheng.zeninventory.service.SupplierServices;
import com.zheng.zeninventory.service.SupplierServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * REST API controller for supplier
 */
@RestController
@RequestMapping("/api")
public class SupplierRestController {

	@Autowired
	private SupplierServices supplierServices;

	@GetMapping("/suppliers")
	public List<Supplier> getAllSupplier(@RequestParam(required = false) String name) {
		return supplierServices.getAllSuppliers();

	}

	@GetMapping("/suppliers/{id}")
	public Optional<Supplier> getSupplierById(@PathVariable("id") long id) {

		return supplierServices.getSupplierById(id);
	}

	@PostMapping("/suppliers")
	public void createSupplier(@RequestBody Supplier supplier) {
		supplierServices.addSupplier(supplier);
	}

	@PutMapping("/suppliers/{id}")
	public void updateSupplier(@PathVariable("id") long id, @RequestBody Supplier supplier) {
		supplierServices.updateSupplier(id, supplier);
	}

	@DeleteMapping("/suppliers/{id}")
	public void deleteSupplier(@PathVariable("id") long id) {
		supplierServices.deleteSupplier(id);
	}

	@DeleteMapping("/suppliers")
	public void deleteAllSuppliers() {

		supplierServices.deleteAllSuppliers();
	}

}
