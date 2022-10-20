package com.zheng.zeninventory.service;

import java.util.List;
import java.util.Optional;

import com.zheng.zeninventory.model.VendorOrder;

/*
 * Service interface for vendor order
 */
public interface VendorOrderServices {

	/*
	 * Method to return all vendor orders
	 */
	public List<VendorOrder> getAllVendorOrders();

	public Optional<VendorOrder> getVendorOrderById(Long id);

	public void createVendorOrder(VendorOrder vendorOrder);
	
	public void updateVendorOrder(long id, VendorOrder vendorOrder);

	public void deleteVendorOrder(long id);

	public void deleteAllVendorOrders();

}

