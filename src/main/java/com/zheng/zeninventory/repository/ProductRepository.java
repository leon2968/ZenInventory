package com.zheng.zeninventory.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zheng.zeninventory.model.Product;

@Repository
/*
 * Repository for product
 */
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	/*
	 * Method to update product quantity using custome query
	 */
	@Modifying
	@Query("UPDATE Product p SET p.productQuantity =:qty WHERE p.productId =:id")
	void updateQtyById(@Param("id")long productId, @Param("qty")int updatedQty);
	
	/*
	 * Method to return understocking products
	 */
	@Query("Select p FROM Product p WHERE p.productQuantity < p.minimumStock")
	List<Product> findUnderstockedProducts();

}
