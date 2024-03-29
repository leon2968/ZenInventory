package com.zheng.zeninventory.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zheng.zeninventory.model.Supplier;

@Repository
/*
 * Repository for supplier
 */
public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}
