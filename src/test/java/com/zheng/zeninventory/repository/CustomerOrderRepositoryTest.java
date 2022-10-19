package com.zheng.zeninventory.repository;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.zheng.zeninventory.model.CustomerOrder;
import com.zheng.zeninventory.model.Product;

//@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CustomerOrderRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    CustomerOrderRepository customerOrderRepository;

    @Test
    public void saveCustomerOrderTest() {
    	CustomerOrder customerOrder = new CustomerOrder();
    	Product product = new Product();
    	product.setProductName("Test Product");
    	
    	customerOrder.setProduct(product);
    	Date today = new Date();
    	customerOrder.setOrderDate(today);

        customerOrder = entityManager.persistAndFlush(customerOrder);

        Assertions.assertEquals(customerOrderRepository.findById(customerOrder.getOrderId()).get() ,customerOrder);
    }
}