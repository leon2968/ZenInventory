package com.zheng.zeninventory.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.zheng.zeninventory.model.CustomerOrder;
import com.zheng.zeninventory.repository.CustomerOrderRepository;

@SpringBootTest
public class CustomerOrderServicesTest {
	/**
	 * Autowire in the service we want to test
	 */
	@Autowired
	private CustomerOrderServices customerOrderServices;

	/**
	 * Create a mock implementation of the CustomerOrderRepository
	 */
	@MockBean
	private CustomerOrderRepository repository;

	@Test
	@DisplayName("Test findById Success")
	public void findByIdTest() {
		// Setup mock repository
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setOrderId(11);
		Mockito.when(repository.findById(1l)).thenReturn(Optional.of(customerOrder));

		// Execute the service call
		Optional<CustomerOrder> returnedCustomerOrder = customerOrderServices.getCustomerOrderById(1l);

		// Assert the response
		Assertions.assertTrue(returnedCustomerOrder.isPresent(), "CustomerOrder was not found");
		Assertions.assertSame(returnedCustomerOrder.get(), customerOrder, "The customerOrder returned was not the same as the mock");
	}
}