package com.zheng.zeninventory.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zheng.zeninventory.model.Product;
import com.zheng.zeninventory.model.Product;
import com.zheng.zeninventory.repository.ProductRepository;
import com.zheng.zeninventory.service.ProductServices;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
/*
 * Service implementation for products
 */
public class ProductServicesImpl implements ProductServices {
	
	@Autowired
	private ProductRepository productRepository;
	
	/*
	 * Method to return all products
	 */
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public void registerProduct(Product product) {
		productRepository.save(product);
	}
	
	@Override
	public void updateProduct(long id, Product product) {
		Optional<Product> productData = productRepository.findById(id);

		if (productData.isPresent()) {
			Product _product = productData.get();
			_product.setProductName(product.getProductName());
			_product.setProductQuantity(product.getProductQuantity());
			_product.setProductDesc(product.getProductDesc());
			_product.setMinimumStock(product.getMinimumStock());
			productRepository.save(_product);
		}
	}
	
	@Override
	public void deleteProduct(long id) {
		productRepository.deleteById(id);
	}
	
	@Override
	public void deleteAllProducts() {
		productRepository.deleteAll();
	}
	
	/*
	 * Method to update product quantity
	 */
	@Transactional
	@Override
	public void updateProductQty(long id, int updatedQty) {
		productRepository.updateQtyById(id, updatedQty);
		
	}
	
	/*
	 * Method to return a list of products with quantity less than minium stock requirement
	 */
	@Override
	public List<Product> findUnderstockProducts() {
		return productRepository.findUnderstockedProducts();
	}



}
