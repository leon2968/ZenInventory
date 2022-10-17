package com.zheng.zeninventory.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="supplier")
public class Supplier implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long supplierId;
	@Column(nullable = false)
	private String supplierName;
	private String supplierAddress;
	private String supplierPhoneNo;
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
    @JoinTable(name = "supplier_product",
    		joinColumns = @JoinColumn(name = "supplier_id"),
    		inverseJoinColumns = @JoinColumn(name = "product_id")
    )
	private List<Product> suppliedProducts;
	
}
