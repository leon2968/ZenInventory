package com.zheng.zeninventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zheng.zeninventory.model.Customer;
import com.zheng.zeninventory.model.CustomerOrder;
import com.zheng.zeninventory.model.Product;

@Repository
/*
 * Repository for customer order
 */
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long>{
	
	/*
	 * Method to find customer order by customer
	 */
	List<CustomerOrder> findByCustomer(Customer customer);
	
	/*
	 * Method to return customer orders with missing customer and/or missing product
	 */
	@Query("Select co FROM CustomerOrder co WHERE co.product IS NULL OR co.customer IS NULL")
	List<CustomerOrder> findCustomerOrdersWithMissingInfo();
}
