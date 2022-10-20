package com.zheng.zeninventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zheng.zeninventory.model.VendorOrder;

@Repository
/*
 * Repository for vendor order
 */
public interface VendorOrderRepository extends JpaRepository<VendorOrder, Long>{
	
	/*
	 * Method to find suppliers by name
	 */
	List<VendorOrder> findBySupplier(String name);
}
