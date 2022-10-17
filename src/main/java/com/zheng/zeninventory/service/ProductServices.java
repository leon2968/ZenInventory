package com.zheng.zeninventory.service;

import java.util.List;
import java.util.Optional;

import com.zheng.zeninventory.model.Product;

public interface ProductServices {

	public List<Product> getAllProducts();

	public Optional<Product> getProductById(Long id);

	public void registerProduct(Product product);
	
	public void updateProduct(long id, Product product);

	public void deleteProduct(long id);

	public void deleteAllProducts();

}


