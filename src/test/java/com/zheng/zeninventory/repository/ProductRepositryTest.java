package com.zheng.zeninventory.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.zheng.zeninventory.model.Product;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProductRepositryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void saveProductTest() {
    	Product product = new Product();
    	product.setProductName("test Product");

        product = entityManager.persistAndFlush(product);

        Assertions.assertEquals(productRepository.findById(product.getProductId()).get(),product);
    }
}