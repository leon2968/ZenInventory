package com.zheng.zeninventory.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.zheng.zeninventory.model.Product;
import com.zheng.zeninventory.repository.ProductRepository;
import com.zheng.zeninventory.service.ProductServices;

public class ProductServicesImpl implements ProductServices {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> getProductById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void registerProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(long id, Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllProducts() {
		// TODO Auto-generated method stub
		
	}

}
