package com.zheng.zeninventory.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zheng.zeninventory.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
