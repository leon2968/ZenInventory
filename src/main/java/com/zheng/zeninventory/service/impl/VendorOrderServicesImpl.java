package com.zheng.zeninventory.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zheng.zeninventory.model.VendorOrder;
import com.zheng.zeninventory.model.VendorOrder;
import com.zheng.zeninventory.repository.VendorOrderRepository;
import com.zheng.zeninventory.service.VendorOrderServices;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
/*
 * Service implementation for vendor order
 */
public class VendorOrderServicesImpl implements VendorOrderServices {
	
	@Autowired
	private VendorOrderRepository vendorOrderRepository;
	
	/*
	 * Method to return all vendor orders
	 */
	@Override
	public List<VendorOrder> getAllVendorOrders() {
		return vendorOrderRepository.findAll();
	}
	
	@Override
	public Optional<VendorOrder> getVendorOrderById(Long id) {
		return vendorOrderRepository.findById(id);
	}
	
	@Override
	public void createVendorOrder(VendorOrder vendorOrder) {
		vendorOrderRepository.save(vendorOrder);
	}
	
	@Override
	public void updateVendorOrder(long id, VendorOrder vendorOrder) {
		Optional<VendorOrder> vendorOrderData = vendorOrderRepository.findById(id);

		if (vendorOrderData.isPresent()) {
			VendorOrder _vendorOrder = vendorOrderData.get();
			_vendorOrder.setSupplier(vendorOrder.getSupplier());
			_vendorOrder.setSuppliedProduct(vendorOrder.getSuppliedProduct());
			_vendorOrder.setSuppliedQuantity(vendorOrder.getSuppliedQuantity());
			_vendorOrder.setCost(vendorOrder.getCost());
			vendorOrderRepository.save(_vendorOrder);
		}
	}
	
	@Override
	public void deleteVendorOrder(long id) {
		vendorOrderRepository.deleteById(id);
	}
	
	@Override
	public void deleteAllVendorOrders() {
		vendorOrderRepository.deleteAll();
	}

}
