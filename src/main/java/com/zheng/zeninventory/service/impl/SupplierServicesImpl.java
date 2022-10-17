package com.zheng.zeninventory.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.zheng.zeninventory.model.Supplier;
import com.zheng.zeninventory.repository.SupplierRepository;
import com.zheng.zeninventory.service.SupplierServices;

public class SupplierServicesImpl implements SupplierServices {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Supplier> getSupplierById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSupplier(long id, Supplier supplier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSupplier(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllSuppliers() {
		// TODO Auto-generated method stub

	}

}
