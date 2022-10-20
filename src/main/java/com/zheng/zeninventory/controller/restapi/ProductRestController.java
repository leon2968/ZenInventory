package com.zheng.zeninventory.controller.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zheng.zeninventory.model.Product;
import com.zheng.zeninventory.model.Product;
import com.zheng.zeninventory.service.ProductServices;
import com.zheng.zeninventory.service.ProductServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * REST API controller for products
 */
@RestController
@RequestMapping("/api")
public class ProductRestController {

	@Autowired
	private ProductServices productServices;

	@GetMapping("/products")
	public List<Product> getAllProduct(@RequestParam(required = false) String name) {
		return productServices.getAllProducts();

	}

	@GetMapping("/products/{id}")
	public Optional<Product> getProductById(@PathVariable("id") long id) {

		return productServices.getProductById(id);
	}

	@PostMapping("/products")
	public void createProduct(@RequestBody Product product) {
		productServices.registerProduct(product);
	}

	@PutMapping("/products/{id}")
	public void updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
		productServices.updateProduct(id, product);
	}

	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable("id") long id) {
		productServices.deleteProduct(id);
	}

	@DeleteMapping("/products")
	public void deleteAllProducts() {

		productServices.deleteAllProducts();
	}

}
