package com.zheng.zeninventory.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.zheng.zeninventory.model.Product;
import com.zheng.zeninventory.repository.ProductRepository;

@SpringBootTest
public class ProductServicesTest {
	/**
	 * Autowire in the service we want to test
	 */
	@Autowired
	private ProductServices productServices;

	/**
	 * Create a mock implementation of the ProductRepository
	 */
	@MockBean
	private ProductRepository repository;

	@Test
	public void findByIdTest() {
		// Setup mock repository
		Product product = new Product();
		product.setProductId(11);
		Mockito.when(repository.findById(1l)).thenReturn(Optional.of(product));

		// Execute the service call
		Optional<Product> returnedProduct = productServices.getProductById(1l);

		// Assert the response
		Assertions.assertTrue(returnedProduct.isPresent(), "Product was not found");
		Assertions.assertSame(returnedProduct.get(), product, "The product returned was not the same as the mock");
	}
}