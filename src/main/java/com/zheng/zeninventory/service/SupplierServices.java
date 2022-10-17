package com.zheng.zeninventory.service;

import java.util.List;
import java.util.Optional;

import com.zheng.zeninventory.model.Supplier;

public interface SupplierServices {

	public List<Supplier> getAllSuppliers();

	public Optional<Supplier> getSupplierById(Long id);

	public void addSupplier(Supplier supplier);

	public void updateSupplier(long id, Supplier supplier);

	public void deleteSupplier(long id);

	public void deleteAllSuppliers();

}