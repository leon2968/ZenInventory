package com.zheng.zeninventory.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.zheng.zeninventory.model.Supplier;
import com.zheng.zeninventory.repository.SupplierRepository;

@SpringBootTest
public class SupplierServicesTest {
	/**
	 * Autowire in the service we want to test
	 */
	@Autowired
	private SupplierServices supplierServices;

	/**
	 * Create a mock implementation of the SupplierRepository
	 */
	@MockBean
	private SupplierRepository repository;

	@Test
	public void findByIdTest() {
		// Setup mock repository
		Supplier supplier = new Supplier();
		supplier.setSupplierId(11);
		Mockito.when(repository.findById(1l)).thenReturn(Optional.of(supplier));

		// Execute the service call
		Optional<Supplier> returnedSupplier = supplierServices.getSupplierById(1l);

		// Assert the response
		Assertions.assertTrue(returnedSupplier.isPresent(), "Supplier was not found");
		Assertions.assertSame(returnedSupplier.get(), supplier, "The supplier returned was not the same as the mock");
	}
}