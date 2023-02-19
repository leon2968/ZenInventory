package com.zheng.zeninventory.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
/*
 * Entity for customer order
 */
public class CustomerOrder extends Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
        })
    @JoinColumn(name = "customer_id")
    @NotFound(action = NotFoundAction.IGNORE)
	private Customer customer;
	
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
        })
    @JoinColumn(name = "product_id")
    @NotFound(action = NotFoundAction.IGNORE)
	private Product product;
	private int purchaseQuantity;
	private double purchasePrice;

}
