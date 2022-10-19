package com.zheng.zeninventory.repository;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.zheng.zeninventory.model.VendorOrder;
import com.zheng.zeninventory.model.Product;
import com.zheng.zeninventory.model.Supplier;

//@ExtendWith(SpringExtension.class)
@DataJpaTest
public class VendorOrderRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    VendorOrderRepository vendorOrderRepository;

    @Test
    public void saveVendorOrderTest() {
    	VendorOrder vendorOrder = new VendorOrder();
    	Product product = new Product();
    	product.setProductName("Test Product");
    	
    	Supplier supplier = new Supplier();
    	supplier.setSupplierName("Test Supplier");
    	
    	Date today = new Date();
    	
    	vendorOrder.setSuppliedProduct(product);
    	vendorOrder.setSupplier(supplier);
    	vendorOrder.setOrderDate(today);

        vendorOrder = entityManager.persistAndFlush(vendorOrder);

        Assertions.assertEquals(vendorOrderRepository.findById(vendorOrder.getOrderId()).get() ,vendorOrder);
    }
}