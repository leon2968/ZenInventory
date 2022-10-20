package com.zheng.zeninventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.zheng.zeninventory.model.Customer;
import com.zheng.zeninventory.model.Product;
import com.zheng.zeninventory.model.Customer;
import com.zheng.zeninventory.service.CustomerServices;
import com.zheng.zeninventory.service.ProductServices;

import lombok.extern.slf4j.Slf4j;

import com.zheng.zeninventory.service.CustomerServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * Controller to handle customer related requests
 */
@Controller
@Slf4j
@RequestMapping("/")
public class CustomerController {

	@Autowired
	private CustomerServices customerServices;
	
	@Autowired
	private ProductServices productServices;
	
    @GetMapping("/registerCustomer")
    public String showForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
         
        return "customer_form";
    }
    
    /*
     * Method to handle customer registration request
     */
    @PostMapping("/registerCustomer")
    public String submitForm(@ModelAttribute("customer") Customer customer) {
        customerServices.addCustomer(customer);
        return "register_customer_success";
    }
    
    /*
     * Method to return customer update page
     */
    @GetMapping("/updateCustomer/{id}")
    public String showUpdateForm(@PathVariable(value = "id") long id, Model model) {
        Optional<Customer> customer = customerServices.getCustomerById(id);
        model.addAttribute("customer", customer);
         
        return "customer_update_form";
    }
    
    /*
     * Method to handle customer update request
     */
    @PostMapping("/updateCustomer")
    public String submitUpdateForm(@ModelAttribute("customer") Customer customer, Model model) {
        //System.out.println(customer);
    	long id = customer.getCustomerId();
    	System.out.println(customer);
        customerServices.updateCustomer(id,customer);
        return showCustomers(model);
    }
    
    /*
     * Method to show a page of all customers
     */
    @GetMapping("/customers")
    public String showCustomers(Model model) {
    	model.addAttribute("listCustomers", customerServices.getAllCustomers());
        return "customers";
    }    
    
    /*
     * Method to handle customer deletion request
     */
    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") long id) {
    	this.customerServices.deleteCustomer(id);
        return "redirect:/customers";
    }    
}


