package com.zheng.zeninventory.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.zheng.zeninventory.model.VendorOrder;
import com.zheng.zeninventory.repository.VendorOrderRepository;

@SpringBootTest
public class VendorOrderServicesTest {
	/**
	 * Autowire in the service we want to test
	 */
	@Autowired
	private VendorOrderServices vendorOrderServices;

	/**
	 * Create a mock implementation of the VendorOrderRepository
	 */
	@MockBean
	private VendorOrderRepository repository;

	@Test
	public void findByIdTest() {
		// Setup mock repository
		VendorOrder vendorOrder = new VendorOrder();
		vendorOrder.setOrderId(11);
		Mockito.when(repository.findById(1l)).thenReturn(Optional.of(vendorOrder));

		// Execute the service call
		Optional<VendorOrder> returnedVendorOrder = vendorOrderServices.getVendorOrderById(1l);

		// Assert the response
		Assertions.assertTrue(returnedVendorOrder.isPresent(), "VendorOrder was not found");
		Assertions.assertSame(returnedVendorOrder.get(), vendorOrder, "The vendorOrder returned was not the same as the mock");
	}
}