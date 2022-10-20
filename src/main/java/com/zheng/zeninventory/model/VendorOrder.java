package com.zheng.zeninventory.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="vendor_order")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@RequiredArgsConstructor
/*
 * Entity for vendor order
 */
public class VendorOrder extends Order implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	private Supplier supplier;
	@Column(nullable = false)
	private Product suppliedProduct;
	@Column(nullable = false)
	private double cost;
	@Column(nullable = false)
	private int suppliedQuantity;

}
