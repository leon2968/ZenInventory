package com.zheng.zeninventory.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.zheng.zeninventory.model.VendorOrder;
import com.zheng.zeninventory.repository.VendorOrderRepository;
import com.zheng.zeninventory.service.VendorOrderServices;

public class VendorOrderServicesImpl implements VendorOrderServices {
	
	@Autowired
	private VendorOrderRepository vendorOrderRepository;
	
	@Override
	public List<VendorOrder> getAllVendorOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<VendorOrder> getVendorOrderById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void createVendorOrder(VendorOrder vendorOrder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateVendorOrder(long id, VendorOrder vendorOrder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteVendorOrder(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllVendorOrders() {
		// TODO Auto-generated method stub

	}

}
