package com.zheng.zeninventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zheng.zeninventory.model.VendorOrder;

@Repository
public interface VendorOrderRepository extends JpaRepository<VendorOrder, Long>{
	List<VendorOrder> findBySupplier(String name);
}
