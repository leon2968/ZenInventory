package com.zheng.zeninventory.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.zheng.zeninventory.model.Customer;
import com.zheng.zeninventory.repository.CustomerRepository;

/*
 * JUnit test for CustomerServices.
 */
@SpringBootTest
public class CustomerServicesTest {

	@Autowired
	private CustomerServices customerServices;

	/**
	 * Create a mock implementation of the CustomerRepository
	 */
	@MockBean
	private CustomerRepository repository;

	@ParameterizedTest
	@CsvSource({"1,1, true",
				"2,7, false",
				"7,7, true",})
	@DisplayName("Parameterized Test Success for findById")
	public void findByIdTest(long id1, long id2, boolean veracity) {
		// Setup mock repository
		Customer customer = new Customer(id1, "Test Customer", "Address123", "123456");
		Mockito.when(repository.findById(id1)).thenReturn(Optional.of(customer));

		// Execute the service call
		Optional<Customer> returnedCustomer = customerServices.getCustomerById(id2);

		// Assert the response
		if(veracity) {
			Assertions.assertTrue(returnedCustomer.isPresent(), "Customer was not found");
			Assertions.assertSame(returnedCustomer.get(), customer, "The customer returned was not the same as the mock");
		} else {
			Assertions.assertFalse(returnedCustomer.isPresent(), "Customer was found");
		}
	}

//	@Test
//	public void findByIdNotFoundTest() {
//		// Setup our mock repository
//		doReturn(Optional.empty()).when(repository).findById(1l);
//
//		// Execute the service call
//		Optional<Customer> returnedCustomer = service.findById(1l);
//
//		// Assert the response
//		Assertions.assertFalse(returnedCustomer.isPresent(), "Customer should not be found");
//	}
//	@Test
//	public void findAllTest() {
//		// Setup our mock repository
//		Customer customer1 = new Customer(1l, "Customer Name", "Description", 1);
//		Customer customer2 = new Customer(2l, "Customer 2 Name", "Description 2", 4);
//		doReturn(Arrays.asList(customer1, customer2)).when(repository).findAll();
//
//		// Execute the service call
//		List<Customer> customerss = service.findAll();
//
//		// Assert the response
//		Assertions.assertEquals(2, customers.size(), "findAll should return 2 customerss");
//	}
//
//	@Test
//	public void saveTest() {
//		// Setup our mock repository
//		Customer customer = new Customer(1l, "Customer Name", "Description", 1);
//		doReturn(customer).when(repository).save(any());
//
//		// Execute the service call
//		Customer returnedCustomer = service.save(customer);
//
//		// Assert the response
//		Assertions.assertNotNull(returnedCustomer, "The saved customer should not be null");
//		Assertions.assertEquals(2, returnedCustomer.getVersion(), "The version should be incremented");
//	}
}
