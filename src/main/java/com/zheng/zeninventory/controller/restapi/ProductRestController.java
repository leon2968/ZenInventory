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

	/*
	 *  To update a record, we used the same save() and findById()
	 */
	@PutMapping("/products/{id}")
   public void updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
		productServices.updateProduct(id, product);
   }

	/*
	 * To delete a vendor order, you simply use the deleteById() method provided
	 * by the productRepository. Then you pass in the id of the record you want to
	 * delete.
	 */
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable("id") long id) {
		productServices.deleteProduct(id);
	}

	@DeleteMapping("/products")
	public void deleteAllProducts() {

		productServices.deleteAllProducts();
	}

}



