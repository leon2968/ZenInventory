package com.zheng.zeninventory.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.zheng.zeninventory.model.Customer;

//@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CustomerRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void saveCustomerTest() {
        Customer customer = new Customer();
        customer.setCustomerName("test customer");

        customer = entityManager.persistAndFlush(customer);

        Assertions.assertEquals(customerRepository.findById(customer.getCustomerId()).get(),customer);
    }
}