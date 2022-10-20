package com.zheng.zeninventory.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zheng.zeninventory.model.Supplier;
import com.zheng.zeninventory.model.Supplier;
import com.zheng.zeninventory.repository.SupplierRepository;
import com.zheng.zeninventory.service.SupplierServices;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
/*
 * Service implementation for supplier
 */
public class SupplierServicesImpl implements SupplierServices {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	/*
	 * Method to return all suppliers
	 */
	@Override
	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}

	@Override
	public Optional<Supplier> getSupplierById(Long id) {
		return supplierRepository.findById(id);
	}

	@Override
	public void addSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	@Override
	public void updateSupplier(long id, Supplier supplier) {
		Optional<Supplier> supplierData = supplierRepository.findById(id);

		if (supplierData.isPresent()) {
			Supplier _supplier = supplierData.get();
			_supplier.setSupplierName(supplier.getSupplierName());
			_supplier.setSupplierAddress(supplier.getSupplierAddress());
			_supplier.setSupplierPhoneNo(supplier.getSupplierPhoneNo());
			_supplier.setSuppliedProducts(supplier.getSuppliedProducts());
			supplierRepository.save(_supplier);
		}
	}
	
	@Override
	public void deleteSupplier(long id) {
		supplierRepository.deleteById(id);
	}
	
	@Override
	public void deleteAllSuppliers() {
		supplierRepository.deleteAll();
	}

}
