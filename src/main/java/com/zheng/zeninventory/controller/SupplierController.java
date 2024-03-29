package com.zheng.zeninventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.zheng.zeninventory.model.Supplier;
import com.zheng.zeninventory.model.Product;
import com.zheng.zeninventory.model.Supplier;
import com.zheng.zeninventory.service.SupplierServices;

import lombok.extern.slf4j.Slf4j;

import com.zheng.zeninventory.service.ProductServices;
import com.zheng.zeninventory.service.SupplierServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * Controller to handle supplier related requests
 */
@Controller
@Slf4j
@RequestMapping("/")
public class SupplierController {

	@Autowired
	private SupplierServices supplierServices;
	
	@Autowired
	private ProductServices productServices;
	
	/*
	 * Method to return supplier registration form
	 */
    @GetMapping("/registerSupplier")
    public String showForm(Model model) {
        Supplier supplier = new Supplier();
        model.addAttribute("supplier", supplier);
        model.addAttribute("listProducts", productServices.getAllProducts()); 
        return "supplier_form";
    }
    
    /*
     * Method to register a new supplier
     */
    @PostMapping("/registerSupplier")
    public String submitForm(@ModelAttribute("supplier") Supplier supplier) {
        //System.out.println(supplier);
        supplierServices.addSupplier(supplier);
        return "register_supplier_success";
    }
    
    /*
     * Method to return supplier update form with given id
     */
    @GetMapping("/updateSupplier/{id}")
    public String showUpdateForm(@PathVariable(value = "id") long id, Model model) {
        Optional<Supplier> supplier = supplierServices.getSupplierById(id);
        model.addAttribute("supplier", supplier);
        model.addAttribute("listProducts", productServices.getAllProducts()); 
        return "supplier_update_form";
    }
    
    /*
     * Method to update supplier with given id
     */
    @PostMapping("/updateSupplier")
    public String submitUpdateForm(@ModelAttribute("supplier") Supplier supplier, Model model) {
        //System.out.println(supplier);
    	long id = supplier.getSupplierId();
    	//System.out.println(supplier);
        supplierServices.updateSupplier(id,supplier);
        return showSuppliers(model);
    }
    
    /*
     * Method to show a page of all suppliers
     */
    @GetMapping("/suppliers")
    public String showSuppliers(Model model) {
    	model.addAttribute("listSuppliers", supplierServices.getAllSuppliers());
        return "suppliers";
    }    
    
    /*
     * Method to delete supplier with given id
     */
    @GetMapping("/deleteSupplier/{id}")
    public String deleteSuppliers(@PathVariable(value = "id") long id) {
    	this.supplierServices.deleteSupplier(id);
        return "redirect:/suppliers";
    }    
}