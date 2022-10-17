package com.zheng.zeninventory.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customer_order")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class CustomerOrder extends Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
    @JoinColumn(name = "customer_id")
	private Customer customer;
	
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
    @JoinColumn(name = "product_id")
	private Product product;
	private int purchaseQuantity;
	private double purchasePrice;

}
