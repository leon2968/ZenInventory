package com.zheng.zeninventory.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.zheng.zeninventory.model.Supplier;

//@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SupplierRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    SupplierRepository supplierRepository;

    @Test
    public void saveSupplierTest() {
    	Supplier supplier = new Supplier();
    	supplier.setSupplierName("test Supplier");

        supplier = entityManager.persistAndFlush(supplier);

        Assertions.assertEquals(supplierRepository.findById(supplier.getSupplierId()).get(),supplier);
    }
}