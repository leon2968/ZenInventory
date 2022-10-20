package com.zheng.zeninventory.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/*
 * This abstract class does not map to an entity
 */
@MappedSuperclass
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	@Column(nullable = false)
	@DateTimeFormat(iso=ISO.DATE)
	private Date orderDate;
	//private Date expectedDeliveryDate;
	private String status;
}
