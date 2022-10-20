package com.zheng.zeninventory.service;

import java.util.List;
import java.util.Optional;

import com.zheng.zeninventory.model.Product;

/*
 * Service interface for prodcuts
 */
public interface ProductServices {
	
	/*
	 * Method to return all products
	 */
	public List<Product> getAllProducts();

	public Optional<Product> getProductById(Long id);

	public void registerProduct(Product product);
	
	public void updateProduct(long id, Product product);

	public void deleteProduct(long id);

	public void deleteAllProducts();
	
	public void updateProductQty(long productId, int updatedQty);
	
	/*
	 * Method to return understocking products
	 */
	public List<Product> findUnderstockProducts();

}


