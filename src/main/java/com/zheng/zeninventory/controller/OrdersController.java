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
import com.zheng.zeninventory.service.CustomerOrderServices;
import com.zheng.zeninventory.service.CustomerServices;
import com.zheng.zeninventory.service.ProductServices;
import com.zheng.zeninventory.service.VendorOrderServices;
import com.zheng.zeninventory.service.CustomerServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class OrdersController {
	
	@Autowired
	private CustomerOrderServices customerOrderServices;
	
	@Autowired
	private VendorOrderServices vendorOrderServices;
	
	@Autowired
	private CustomerServices customerServices;
	
	@Autowired
	private ProductServices productServices;
	
    @GetMapping("/createCustomerOrder")
    public String showForm(Model model) {
        //Customer customer = new Customer();
        //model.addAttribute("customer", customer);
         
        return "";
    }
    
    @PostMapping("/createCustomerOrder")
    public String submitForm(@ModelAttribute("customer") Customer customer) {
        ////System.out.println(customer);
        //customerServices.addCustomer(customer);
        return "";
    }
    
    @GetMapping("/updateCustomerOrder/{id}")
    public String showUpdateForm(@PathVariable(value = "id") long id, Model model) {
        Optional<Customer> customer = customerServices.getCustomerById(id);
        model.addAttribute("customer", customer);
         
        return "customer_update_form";
    }
    
    @PostMapping("/updateCustomerOrder")
    public String submitUpdateForm(@ModelAttribute("customer") Customer customer, Model model) {
        //System.out.println(customer);
    	long id = customer.getCustomerId();
    	System.out.println(customer);
        customerServices.updateCustomer(id,customer);
        return "";
    }
    
    @GetMapping("/orders")
    public String showOrders(Model model) {
    	//model.addAttribute("listCustomers", customerServices.getAllCustomers());
        return "orders";
    }    
    
    @GetMapping("/deleteCustomerOrder/{id}")
    public String showCustomers(@PathVariable(value = "id") long id) {
    	this.customerServices.deleteCustomer(id);
        return "redirect:/orders";
    }    
}


